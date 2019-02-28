package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import communication.TCPConnection;
import communication.TCPConnection.ConnectionListener;
import vista.ChatWindow;
import vista.MainWindow;

public class MainController implements ActionListener, ConnectionListener{
	private MainWindow window;
	TCPConnection connection;
	
	public MainController(MainWindow window) {
		this.window = window;
		initView();
	}


	private void initView() {
		connection = TCPConnection.getInstance(0);
		connection.addListener(this);
		window.getBtnConectar().addActionListener(this);		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(window.getBtnConectar())) {
			System.out.println("HOLA!");
			conectar();			
		}
	}


	private void conectar() {
		String port = window.getTf_port().getText();
		String ip = window.getTf_ip().getText();
		TCPConnection.getInstance(0).connect(ip,Integer.parseInt(port));
	}


	@Override
	public void onConnect() {
		window.setVisible(false);
		ChatWindow chat = new ChatWindow();
		chat.setVisible(true);
	}


	@Override
	public void onMessage(String msj) {
		// TODO Auto-generated method stub
		
	}
	
	
}
