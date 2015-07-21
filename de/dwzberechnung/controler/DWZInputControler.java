package de.dwzberechnung.controler;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import de.dwzberechnung.model.MainModel;
import de.dwzberechnung.model.OpponentModel;
import de.dwzberechnung.model.PlayerModel;
import de.dwzberechnung.view.DWZInputView;
import de.dwzberechnung.view.MainPanelView;
import de.dwzberechnung.view.MainWindowView;
import de.dwzberechnung.view.PanelButtonView;
//DWZ Rechner - Ein Programm zum Berechnen von DWZ Zahlen von Schach Turnieren
//Copyright (C) 2015  Martin Schmuck m_schmuck@gmx.net
//
//This program is free software: you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation, either version 3 of the License, or
//(at your option) any later version.
//
//This program is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with this program.  If not, see <http://www.gnu.org/licenses/>.
public class DWZInputControler implements ActionListener {

	private MainControler mainControl;
	private MainWindowView frame;
	private DWZPropertiesControler dwzPropertiesController;
	private int numberOfPlayers;
	private PanelButtonView okButtonView;
	private MainPanelView panel;
	private JPanel inputPanel;
	private ArrayList<DWZInputView> dwzInputPanel;
	private PlayerModel spieler;
	private ArrayList<OpponentModel> oppList;

	public DWZInputControler(MainControler mainControl) {
		this.mainControl = mainControl;
		this.frame = this.mainControl.getFrame();
		this.numberOfPlayers = this.mainControl.getNumberOfPlayersController().getNumberOfPlayers();
		this.dwzPropertiesController = this.mainControl.getDwzPropertiesController();
		dwzInputPanel = new ArrayList<DWZInputView>();
		inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));
		JPanel dreiSpalten = new JPanel();
		dreiSpalten.setLayout(new FlowLayout(FlowLayout.LEFT));
		for (int i = 0; i < this.numberOfPlayers; i++) {
			DWZInputView dwziv = new DWZInputView();
			String key = "DWZ" + new Integer(i);
			String dwzWert = this.dwzPropertiesController.getDwzProps().getProperty(key);
			dwziv.getDwzInputField().setText(dwzWert);
			key = "Ergebniss" + new Integer(i);
			String ergebniss = this.dwzPropertiesController.getDwzProps().getProperty(key);
			int selectedIndex = 0;
			try {
				selectedIndex = Integer.parseInt(ergebniss);
			} catch (NumberFormatException e) {
				selectedIndex = 0;
			}

			dwziv.getErgebniss().setSelectedIndex(selectedIndex);
			dwzInputPanel.add(dwziv);
			dreiSpalten.add(dwzInputPanel.get(i));

			if ((i + 1) % 3 == 0) {
				inputPanel.add(dreiSpalten);
				dreiSpalten = new JPanel();
				dreiSpalten.setLayout(new FlowLayout(FlowLayout.LEFT));

			}

			if (this.numberOfPlayers % 3 > 0 && this.numberOfPlayers - (i + 1) == 1) {
				inputPanel.add(dreiSpalten);
			}

			if (this.numberOfPlayers == 1) {
				inputPanel.add(dreiSpalten);
			}

		}
		okButtonView = new PanelButtonView();
		okButtonView.getNavigatorButton().addActionListener(this);
		okButtonView.getActionButton().addActionListener(this);
		okButtonView.getExitButton().addActionListener(this);
		okButtonView.setNavigatorButtonName("Zurück");
		okButtonView.setActionButtonName("DWZ errechnen");
		panel = new MainPanelView();
		panel.setNorthPanel(new JLabel("DWZ Berechnung"));
		panel.setCenterPanel(inputPanel);
		panel.setSouthPanel(okButtonView);

		this.frame.setContentPane(panel);
		this.frame.setEnabled(true);
		this.frame.setVisible(true);

	}

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == okButtonView.getNavigatorButton()) {
			saveDWZProps();
			this.mainControl.setNumberOfPlayersController(new NumberOfPlayersControler(this.mainControl));

		}
		if (arg0.getSource() == okButtonView.getActionButton()) {
			if (checkDWZ() == true) {
				
				
				this.mainControl.setMainModel(new MainModel(spieler, oppList));
				
				ResultDialogControler resultDialogController = new ResultDialogControler(this.mainControl);
			}

		}
		if (arg0.getSource() == okButtonView.getExitButton()) {

			saveDWZProps();
			saveApplicationProps();
			System.exit(0);

		}
	}

	private Boolean checkDWZ() {
		saveDWZProps();
		saveApplicationProps();
		spieler = new PlayerModel(mainControl.getAge(), mainControl.getOldDWZ(),
				mainControl.getNumberOfPlayers());
		oppList = new ArrayList<OpponentModel>();
		Boolean richtig = true;
		DWZInputView dwztemp = null;
		double gesamtpunkte = 0;
		try {
			for (DWZInputView dwziv : dwzInputPanel) {
				dwztemp = dwziv;
				double punkt = 0;

				if (dwziv.getErgebniss().getSelectedIndex() == 0) {
					punkt = 0;
				}
				if (dwziv.getErgebniss().getSelectedIndex() == 1) {
					punkt = 0.50;
				}
				if (dwziv.getErgebniss().getSelectedIndex() == 2) {
					punkt = 1.0;
				}

				int dwzOfOpponent = Integer.parseInt(dwziv.getDwzInputField().getText());
				if (dwzOfOpponent >= 0 && dwzOfOpponent <= 3000) {
					oppList.add(new OpponentModel(dwzOfOpponent, punkt));
					gesamtpunkte += punkt;
				} else {
					JOptionPane.showMessageDialog(null,
							"Die DWZ muss eine Ganzzahl sein " + "und zwischen 0 und 3000 liegen.", "Fehler!",
							JOptionPane.WARNING_MESSAGE);
					dwziv.getDwzInputField().setText(null);
					dwziv.getDwzInputField().grabFocus();
					richtig = false;

					break;
				}
			}
			spieler.setPunkte(gesamtpunkte);

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Die DWZ muss eine Ganzzahl sein " + "und zwischen 0 und 3000 liegen.",
					"Fehler!", JOptionPane.WARNING_MESSAGE);
			dwztemp.getDwzInputField().setText(null);
			dwztemp.getDwzInputField().grabFocus();
			richtig = false;
		}
		return richtig;
	}

	private void saveDWZProps() {
		Properties dwzProps = new Properties();
		Integer i = 0;
		for (DWZInputView dwzPanel : dwzInputPanel) {
			String key = "DWZ" + i.toString();
			dwzProps.setProperty(key, dwzPanel.getDwzInputField().getText());
			key = "Ergebniss" + i.toString();
			dwzProps.setProperty(key, new Integer(dwzPanel.getErgebniss().getSelectedIndex()).toString());
			i++;
		}
		dwzPropertiesController.setDwzProps(dwzProps);
		dwzPropertiesController.saveDWZProperties();
	}

	private void saveApplicationProps() {
		dwzPropertiesController.getApplicationProps().setProperty("lastpage", "2");
		dwzPropertiesController.saveAppProperties();
	}
}
