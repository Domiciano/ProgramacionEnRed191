package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import communication.TCPConnection;
import communication.TCPConnection.ConnectionEvent;
import view.ViewChat;

public class ControllerChat implements ActionListener, ConnectionEvent{
	private ViewChat view;
	TCPConnection connection;
	
	public ControllerChat(ViewChat view) {
		this.view = view;
		initView();
	}
	
	public void initView() {
		view.getBtnEnviar().addActionListener(this);
		connection = TCPConnection.getInstance();
		connection.addConnectionEvent(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(view.getBtnEnviar())) {
			connection.sendMessage( view.getTfEntrada().getText() );
			view.getTaMensajes().append(view.getTfEntrada().getText() + "\n");
			view.getTfEntrada().setText("");
		}
	}

	@Override
	public void onConnection() {
		//No lo tenemos que manejar		
	}

	@Override
	public void onMessage(String msj) {
		System.out.println(">>ControllerChat: " + msj);
		view.getTaMensajes().append(msj+"\n");
	}

}