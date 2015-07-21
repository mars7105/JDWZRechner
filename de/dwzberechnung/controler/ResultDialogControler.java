package de.dwzberechnung.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import de.dwzberechnung.model.PlayerModel;
import de.dwzberechnung.view.DWZErgebnisPanelView;
import de.dwzberechnung.view.ResultDialogView;
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
public class ResultDialogControler implements ActionListener {

	private ResultDialogView resultDialogView;
	private MainControler mainControl;
	@SuppressWarnings("unused")
	private DWZErgebnisPanelView dwzErgebnisPanelView;
	private DecimalFormat myFormatterDouble;
	private DecimalFormat myFormatterDoubleB;
	private DecimalFormat myFormatterInt;
	@SuppressWarnings("unused")
	private DecimalFormat myFormatterDWZ;

	public ResultDialogControler(MainControler mainControl) {
		this.mainControl = mainControl;
		myFormatterDouble = new DecimalFormat("0.00");
		myFormatterDoubleB = new DecimalFormat("0.000");
		myFormatterInt = new DecimalFormat("0");
		myFormatterDWZ = new DecimalFormat("0000");
		try {
			resultDialogView = new ResultDialogView();
			resultDialogView.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			makeDWZErgebnisView();
			resultDialogView.setVisible(true);
			resultDialogView.getOkButton().addActionListener(this);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void makeDWZErgebnisView() {

		PlayerModel pmodel = mainControl.getMainModel().getPlayer();
		String punkterwartung = myFormatterDoubleB.format(pmodel.getPunkterwartung());
		String punkte = myFormatterDouble.format(pmodel.getPunkte());
		String folgeDWZ = myFormatterInt.format(pmodel.getFolgeDWZ());
		String leistungsDWZ = myFormatterInt.format(pmodel.getLeistungsDWZ());
		String oldDWZ = myFormatterInt.format(pmodel.getOldDWZ());
		String dSchnittsZahlDWZ = myFormatterInt.format(pmodel.getDurchschnittderGegnerDWZ());
		String patien = new Integer(pmodel.getNumberOfOpponents()).toString();
		String prozentGewinn = myFormatterDouble.format(100 * pmodel.getPunkte() / pmodel.getNumberOfOpponents());
		String entwicklungskoeffizient =  myFormatterInt.format(pmodel.getEntwicklungskoeffizient()).toString();

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		DWZErgebnisPanelView dwzErgebnisPanelView1b = new DWZErgebnisPanelView("Durchschnitt der Gegner :",
				dSchnittsZahlDWZ);
		panel.add(dwzErgebnisPanelView1b);
		DWZErgebnisPanelView dwzErgebnisPanelView0 = new DWZErgebnisPanelView("alte DWZ :", oldDWZ);
		panel.add(dwzErgebnisPanelView0);
		DWZErgebnisPanelView dwzErgebnisPanelView1 = new DWZErgebnisPanelView("neue DWZ :", folgeDWZ);
		panel.add(dwzErgebnisPanelView1);
		DWZErgebnisPanelView dwzErgebnisPanelView2 = new DWZErgebnisPanelView("Leistungszahl :", leistungsDWZ);
		panel.add(dwzErgebnisPanelView2);
		DWZErgebnisPanelView dwzErgebnisPanelView4 = new DWZErgebnisPanelView("Punkteerwartung :",
				punkterwartung + " von " + patien + " Partien");
		panel.add(dwzErgebnisPanelView4);
		DWZErgebnisPanelView dwzErgebnisPanelView3 = new DWZErgebnisPanelView("Punkte :",
				punkte + " von " + patien + " Partien");
		panel.add(dwzErgebnisPanelView3);
		DWZErgebnisPanelView dwzErgebnisPanelView3b = new DWZErgebnisPanelView("Punkte in Prozent :",
				prozentGewinn + "%");
		panel.add(dwzErgebnisPanelView3b);
		DWZErgebnisPanelView dwzErgebnisPanelView5 = new DWZErgebnisPanelView("Entwicklungskoeffizient :",
				entwicklungskoeffizient);
		panel.add(dwzErgebnisPanelView5);

		resultDialogView.setContentPanel(panel);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == resultDialogView.getOkButton()) {
			resultDialogView.dispose();
		}
	}

	@SuppressWarnings("unused")
	private String format(double i) {
		DecimalFormat f = new DecimalFormat("#0.00");
		double toFormat = ((double) Math.round(i * 100)) / 100;
		return f.format(toFormat);
	}
}
