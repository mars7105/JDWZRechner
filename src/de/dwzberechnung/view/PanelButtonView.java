package de.dwzberechnung.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
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
public class PanelButtonView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton navigatorButton;
	private JButton actionButton;
	private JButton exitButton;

	/**
	 * Create the panel.
	 */
	public PanelButtonView() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		navigatorButton = new JButton("Weiter");
		actionButton = new JButton("Reset");
		exitButton = new JButton("Beenden");
		add(navigatorButton);
		add(actionButton);
		add(exitButton);
		this.updateUI();
		this.setEnabled(true);
		this.setVisible(true);

	}

	public JButton getNavigatorButton() {
		return navigatorButton;
	}

	public void setNavigatorButton(JButton okButton) {
		this.navigatorButton = okButton;
	}

	public void setNavigatorButtonName(String name) {
		this.navigatorButton.setText(name);
	}

	public JButton getActionButton() {
		return actionButton;
	}

	public void setActionButton(JButton cancelButton) {
		this.actionButton = cancelButton;
	}

	public void setActionButtonName(String name) {
		this.actionButton.setText(name);
	}

	public JButton getExitButton() {
		return exitButton;
	}

	public void setExitButton(JButton exitButton) {
		this.exitButton = exitButton;
	}

	

}
