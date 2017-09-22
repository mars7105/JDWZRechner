package de.dwzberechnung.controler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
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
public class DWZPropertiesControler {
	private Properties defaultProps;
	private Properties applicationProps;
	private Properties dwzProps;

	public DWZPropertiesControler() {
		// create and load default properties
		defaultProps = new Properties();

		try {
			FileInputStream in;
			in = new FileInputStream("defaultProperties");
			defaultProps.load(in);
			in.close();
		} catch (IOException e) {
			saveDefaultProperties();
		}

		// create application properties with default
		applicationProps = new Properties(defaultProps);

		// now load properties
		// from last invocation
		try {
			FileInputStream in;
			in = new FileInputStream("appProperties");
			applicationProps.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		// create application properties with default
		dwzProps = new Properties();
		// now load properties
		// from last invocation
		try {
			FileInputStream in;
			in = new FileInputStream("dwzProperties");
			dwzProps.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}

	public void saveAppProperties() {
		FileOutputStream out;
		try {
			out = new FileOutputStream("appProperties");

			applicationProps.store(out, "---No Comment---");

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveDefaultProperties() {
		defaultProps.setProperty("age", "0");
		defaultProps.setProperty("numberofplayer", "1");
		defaultProps.setProperty("olddwz", "");
		defaultProps.setProperty("lastpage", "1");
		FileOutputStream out;
		try {
			out = new FileOutputStream("defaultProps");

			defaultProps.store(out, "---No Comment---");

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveDWZProperties() {
		FileOutputStream out;
		try {
			out = new FileOutputStream("dwzProperties");

			dwzProps.store(out, "---No Comment---");

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Properties getDefaultProps() {
		return defaultProps;
	}

	public void setDefaultProps(Properties defaultProps) {
		this.defaultProps = defaultProps;
	}

	public Properties getApplicationProps() {
		return applicationProps;
	}

	public void setApplicationProps(Properties applicationProps) {
		this.applicationProps = applicationProps;
	}

	public Properties getDwzProps() {
		return dwzProps;
	}

	public void setDwzProps(Properties dwzProps) {
		this.dwzProps = dwzProps;
	}

}