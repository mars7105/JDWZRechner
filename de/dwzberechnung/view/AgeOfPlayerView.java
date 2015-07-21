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
public class AgeOfPlayerView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> ageOfPlayer;

	/**
	 * Create the panel.
	 */
	public AgeOfPlayerView() {
//		Border blackline = BorderFactory.createLineBorder(Color.gray);

//		this.setBorder(blackline);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel label = new JLabel("Dein Alter:");
		add(label);
		String[] age = { "bis 20 Jahre", "21 bis 25 Jahre", "über 25 Jahre" };
		ageOfPlayer = new JComboBox<String>(age);
		add(ageOfPlayer);

		this.updateUI();
		this.setEnabled(true);
		this.setVisible(true);
	}

	public JComboBox<String> getAgeOfPlayer() {
		return ageOfPlayer;
	}

	public void setAgeOfPlayer(JComboBox<String> ageOfPlayer) {
		this.ageOfPlayer = ageOfPlayer;
	}

}
