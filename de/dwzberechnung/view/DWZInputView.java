package de.dwzberechnung.view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
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
public class DWZInputView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField dwzInputField;
	private JComboBox<String> ergebniss;
	/**
	 * Create the panel.
	 */
	public DWZInputView() {
		Border blackline = BorderFactory.createLineBorder(Color.gray);
		this.setBorder(blackline);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel label = new JLabel("DWZ :");
		dwzInputField = new JTextField(4);
		String[] jc = { "0", "0.5", "1" };
		ergebniss = new JComboBox<String>(jc);
		ergebniss.setSelectedIndex(0);
		add(label);
		add(dwzInputField);
		add(ergebniss);
		this.updateUI();
		this.setEnabled(true);
		this.setVisible(true);
	}
	public JTextField getDwzInputField() {
		return dwzInputField;
	}
	public void setDwzInputField(JTextField dwzInputField) {
		this.dwzInputField = dwzInputField;
	}
	public JComboBox<String> getErgebniss() {
		return ergebniss;
	}
	public void setErgebniss(JComboBox<String> ergebniss) {
		this.ergebniss = ergebniss;
	}
	
	

}
