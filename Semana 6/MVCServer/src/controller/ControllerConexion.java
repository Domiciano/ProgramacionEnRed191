package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import communication.TCPConnection;
import communication.TCPConnection.ConnectionEvent;
import view.ViewChat;
import view.ViewConexion;

public class ControllerConexion implements ConnectionEvent{

	private ViewConexion view;
	TCPConnection connection;
	
	public ControllerConexion(ViewConexion view) {
		this.view = view;
		initView();
	}

	public void initView() {
		connection = TCPConnection.getInstance(5000);
		connection.addConnectionEvent(this);
		new Thread( () ->  connection.waitForConnection(5000) ).start();
		
	}
	
	
	
	
	@Override
	public void onConnection() {
		//Desplegar la siguiente ventana
		System.out.println("CONECTADOS!");
		view.setVisible(false);
		
		ViewChat chat = new ViewChat();
		chat.setVisible(true);
		
	}

	@Override
	public void onMessage(String msj) {
		//No vamos a tomar acciones	
	}
	
	
}
