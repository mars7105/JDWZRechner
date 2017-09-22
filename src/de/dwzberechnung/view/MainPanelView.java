package de.dwzberechnung.view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
public class MainPanelView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel northPanel;
	private JPanel centerPanel;
	private JPanel southPanel;

	/**
	 * Create the panel.
	 */
	public MainPanelView() {
//		Border blackline = BorderFactory.createLineBorder(Color.gray);
		this.setLayout(new BorderLayout());
//		this.setBorder(blackline);

	}

	public JLabel getNorthPanel() {
		return northPanel;
	}

	public void setNorthPanel(JLabel northPanel) {
		this.northPanel = northPanel;
		add(this.northPanel, BorderLayout.NORTH);
	}

	public JPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
		JScrollPane scrollPane = new JScrollPane(this.centerPanel);
		add(scrollPane, BorderLayout.CENTER);
	}

	public JPanel getSouthPanel() {
		return southPanel;
	}

	public void setSouthPanel(JPanel southPanel) {
		this.southPanel = southPanel;
		add(this.southPanel, BorderLayout.SOUTH);
	}

}
