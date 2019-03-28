package main;

import db.SQLConnection;
import view.MainView;

public class Launcher {

	public static void main(String[] args) {
		SQLConnection.getInstance();		
		MainView view = new MainView();
		view.setVisible(true);
	}

}
