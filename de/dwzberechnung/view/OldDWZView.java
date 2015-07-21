package de.dwzberechnung.view;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
public class OldDWZView extends JPanel {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JTextField oldDWZTextField;
	/**
	 * Create the panel.
	 */
	public OldDWZView() {
//		Border blackline = BorderFactory.createLineBorder(Color.gray);

//		this.setBorder(blackline);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel label = new JLabel("Deine aktuelle DWZ:");
		add(label);
		oldDWZTextField = new JTextField(4);
		add(oldDWZTextField);
		this.updateUI();
		this.setEnabled(true);
		this.setVisible(true);
	}
	public JTextField getOldDWZTextField() {
		return oldDWZTextField;
	}
	public void setOldDWZTextField(JTextField oldDWZTextField) {
		this.oldDWZTextField = oldDWZTextField;
	}

}
