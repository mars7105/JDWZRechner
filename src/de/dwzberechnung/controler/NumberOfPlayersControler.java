package de.dwzberechnung.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import de.dwzberechnung.view.AgeOfPlayerView;
import de.dwzberechnung.view.MainPanelView;
import de.dwzberechnung.view.MainWindowView;
import de.dwzberechnung.view.NumberOfPlayersView;
import de.dwzberechnung.view.OldDWZView;
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
public class NumberOfPlayersControler implements ActionListener {

	private MainControler mainControl;
	private MainWindowView frame;
	private DWZPropertiesControler dwzPropertiesController;
	private int numberOfPlayers;
	private int age;
	private int dwzOfPlayer;
	private NumberOfPlayersView numberOfPlayersView;
	private AgeOfPlayerView ageOfPlayerView;
	private OldDWZView oldDWZView;
	private PanelButtonView okButtonView;
	private MainPanelView panel;

	public NumberOfPlayersControler(MainControler mainControl) {
		this.mainControl = mainControl;
		this.frame = this.mainControl.getFrame();
		this.dwzPropertiesController = this.mainControl.getDwzPropertiesController();

		try {
			numberOfPlayers = Integer
					.parseInt(this.dwzPropertiesController.getApplicationProps().getProperty("numberofplayer"));
		} catch (NumberFormatException e) {
			numberOfPlayers = 1;

		}
		numberOfPlayersView = new NumberOfPlayersView();
		numberOfPlayersView.getNumberOfPlayersTextField().setSelectedIndex(numberOfPlayers - 1);
		ageOfPlayerView = new AgeOfPlayerView();
		int age = 0;
		try {
			age = Integer.parseInt(this.dwzPropertiesController.getApplicationProps().getProperty("age"));
			if (age > 2 || age < 0) {
				age = 0;
			}
		} catch (NumberFormatException e) {
			age = 0;

		}
		ageOfPlayerView.getAgeOfPlayer().setSelectedIndex(age);
		oldDWZView = new OldDWZView();
		oldDWZView.getOldDWZTextField()
				.setText(this.dwzPropertiesController.getApplicationProps().getProperty("olddwz"));
		okButtonView = new PanelButtonView();
		okButtonView.getNavigatorButton().addActionListener(this);
		okButtonView.getActionButton().addActionListener(this);
		okButtonView.getExitButton().addActionListener(this);
		JPanel zentrum = new JPanel();
		zentrum.setLayout(new BoxLayout(zentrum, BoxLayout.PAGE_AXIS));
		zentrum.add(ageOfPlayerView);
		zentrum.add(oldDWZView);
		zentrum.add(numberOfPlayersView);
		panel = new MainPanelView();
		panel.setNorthPanel(new JLabel("DWZ Berechnung"));
		panel.setCenterPanel(zentrum);
		panel.setSouthPanel(okButtonView);

		this.frame.setContentPane(panel);
		this.frame.setEnabled(true);
		this.frame.setVisible(true);
		this.frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				numberOfPlayersView.getNumberOfPlayersTextField().requestFocus();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == okButtonView.getNavigatorButton()) {
			numberOfPlayers = 1 + numberOfPlayersView.getNumberOfPlayersTextField().getSelectedIndex();
			age = ageOfPlayerView.getAgeOfPlayer().getSelectedIndex();
			try {
				if (oldDWZView.getOldDWZTextField().getText().equals("")) {
					this.mainControl.setAge(age);
					this.mainControl.setOldDWZ(0);
					this.mainControl.setNumberOfPlayers(numberOfPlayers);
					saveApplicationProps();
					this.mainControl.setDwzInputController(new DWZInputControler(this.mainControl));
				} else {
					dwzOfPlayer = Integer.parseInt(oldDWZView.getOldDWZTextField().getText());
					if (dwzOfPlayer >= 0 && dwzOfPlayer <= 3000) {
						this.mainControl.setAge(age);
						this.mainControl.setOldDWZ(dwzOfPlayer);
						this.mainControl.setNumberOfPlayers(numberOfPlayers);
						saveApplicationProps();
						this.mainControl.setDwzInputController(new DWZInputControler(this.mainControl));
					} else {
						JOptionPane.showMessageDialog(null,
								"Die DWZ muss eine Ganzzahl sein " + "und zwischen 0 und 3000 liegen.", "Fehler!",
								JOptionPane.WARNING_MESSAGE);
						oldDWZView.getOldDWZTextField().setText(null);
						oldDWZView.getOldDWZTextField().grabFocus();
					}
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
						"Die DWZ muss eine Ganzzahl sein " + "und zwischen 0 und 3000 liegen.", "Fehler!",
						JOptionPane.WARNING_MESSAGE);
				oldDWZView.getOldDWZTextField().setText(null);
				oldDWZView.getOldDWZTextField().grabFocus();
			}

		}

		if (arg0.getSource() == okButtonView.getActionButton()) {
			dwzPropertiesController.setDwzProps(new Properties(dwzPropertiesController.getDefaultProps()));
			dwzPropertiesController.saveDWZProperties();
			dwzPropertiesController.setApplicationProps(new Properties());
			dwzPropertiesController.saveAppProperties();
			loadDefaultProps();
		}
		if (arg0.getSource() == okButtonView.getExitButton()) {
			saveApplicationProps();
			System.exit(0);
		}
	}

	private void saveApplicationProps() {
		Properties applicationProps = new Properties();
		Integer age = ageOfPlayerView.getAgeOfPlayer().getSelectedIndex();
		String olddwz = oldDWZView.getOldDWZTextField().getText();
		Integer numberOfPlayer = 1 + numberOfPlayersView.getNumberOfPlayersTextField().getSelectedIndex();
		applicationProps.setProperty("age", age.toString());
		applicationProps.setProperty("olddwz", olddwz);
		applicationProps.setProperty("numberofplayer", numberOfPlayer.toString());
		applicationProps.setProperty("lastpage", "1");

		dwzPropertiesController.setApplicationProps(applicationProps);
		dwzPropertiesController.saveAppProperties();
	}

	private void loadDefaultProps() {
		Properties defaultProps = new Properties();
		defaultProps = dwzPropertiesController.getDefaultProps();
		int age = Integer.parseInt(defaultProps.getProperty("age"));
		ageOfPlayerView.getAgeOfPlayer().setSelectedIndex(age);
		String olddwz = defaultProps.getProperty("olddwz");
		oldDWZView.getOldDWZTextField().setText(olddwz);
		int numberofplayer = Integer.parseInt(defaultProps.getProperty("numberofplayer"));
		numberOfPlayersView.getNumberOfPlayersTextField().setSelectedIndex(numberofplayer - 1);
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

}
