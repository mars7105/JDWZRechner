package de.dwzberechnung.view;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
public class MainWindowView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPane;


	/**
	 * Create the frame.
	 */
	public MainWindowView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("DWZ Rechner");
		setBounds(100, 100, 550, 300);
		assignIcon();
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPane.setLayout(new FlowLayout());
		this.getContentPane().add(mainPane);
		
	}


	public JPanel getMainPane() {
		return mainPane;
	}


	public void setMainPane(JPanel contentPane) {
		this.mainPane = contentPane;
		this.getContentPane().add(contentPane);
		setVisible(true);
	}
	private void assignIcon() {
		java.net.URL iconUrl = this.getClass().getResource("jdwzrechner.png");
		Image img = getToolkit().getImage(iconUrl);
		MediaTracker mt = new MediaTracker(this);

		mt.addImage(img, 0);
		setIconImage(img);
		} 

}
