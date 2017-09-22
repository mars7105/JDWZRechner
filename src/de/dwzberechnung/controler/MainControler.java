/**
 * 
 */
package de.dwzberechnung.controler;

import javax.swing.JFrame;

import de.dwzberechnung.model.MainModel;
import de.dwzberechnung.view.MainWindowView;

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
/**
 * @author mars
 *
 */
public class MainControler {
	private MainWindowView frame;
	private DWZPropertiesControler dwzPropertiesController;
	private DWZInputControler dwzInputController;
	private NumberOfPlayersControler numberOfPlayersController;
	private int age;
	private int numberOfPlayers;
	private int oldDWZ;

	private MainModel mainModel;

	public MainControler() {
		showWindow();

		dwzPropertiesController = new DWZPropertiesControler();

		numberOfPlayersController = new NumberOfPlayersControler(this);

	}

	public void showWindow() {
		
		try {
			frame = new MainWindowView();
			// Make sure we have nice window decorations.
			JFrame.setDefaultLookAndFeelDecorated(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MainWindowView getFrame() {
		return frame;
	}

	public void setFrame(MainWindowView frame) {
		this.frame = frame;
	}

	public DWZPropertiesControler getDwzPropertiesController() {
		return dwzPropertiesController;
	}

	public void setDwzPropertiesController(DWZPropertiesControler dwzPropertiesController) {
		this.dwzPropertiesController = dwzPropertiesController;
	}

	public DWZInputControler getDwzInputController() {
		return dwzInputController;
	}

	public void setDwzInputController(DWZInputControler dwzInputController) {
		this.dwzInputController = dwzInputController;
	}

	public NumberOfPlayersControler getNumberOfPlayersController() {
		return numberOfPlayersController;
	}

	public void setNumberOfPlayersController(NumberOfPlayersControler numberOfPlayersController) {
		this.numberOfPlayersController = numberOfPlayersController;
	}

	public MainModel getMainModel() {
		return mainModel;
	}

	public void setMainModel(MainModel mainModel) {
		this.mainModel = mainModel;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public int getOldDWZ() {
		return oldDWZ;
	}

	public void setOldDWZ(int oldDWZ) {
		this.oldDWZ = oldDWZ;
	}

}
