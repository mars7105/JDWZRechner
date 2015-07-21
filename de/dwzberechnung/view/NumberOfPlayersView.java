package de.dwzberechnung.view;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
public class NumberOfPlayersView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> numberOfPlayersTextField;

	/**
	 * Create the panel.
	 */
	public NumberOfPlayersView() {
		makePanel();
	}

	public void makePanel() {
//		Border blackline = BorderFactory.createLineBorder(Color.gray);

//		this.setBorder(blackline);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel label = new JLabel("Anzahl der Gegner:");
		add(label);
		String[] zahlen = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20" };

		numberOfPlayersTextField = new JComboBox<String>(zahlen);

		add(numberOfPlayersTextField);

		this.updateUI();
		this.setEnabled(true);
		this.setVisible(true);
	}

	public JComboBox<String> getNumberOfPlayersTextField() {
		return numberOfPlayersTextField;
	}

	public void setNumberOfPlayersTextField(JComboBox<String> numberOfPlayersTextField) {
		this.numberOfPlayersTextField = numberOfPlayersTextField;
	}

}
