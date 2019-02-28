package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import communication.TCPConnection;
import communication.TCPConnection.ConnectionListener;
import vista.ChatWindow;

public class ChatController implements ActionListener, ConnectionListener{

	private ChatWindow window;
	TCPConnection conexion;
	
	public ChatController(ChatWindow window) {
		this.window = window;
		initView();
	}

	private void initView() {
		window.getSendButton().addActionListener(this);
		conexion = TCPConnection.getInstance();
		conexion.addListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(window.getSendButton())) {
			System.out.println("Eviando...");
			conexion.sendMessage( window.getTfInput().getText() );
		}
	}

	@Override
	public void onConnect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(String msj) {
		System.out.println("ONMESSAGE");
		window.getArea().setText(msj);
	}
	

}
