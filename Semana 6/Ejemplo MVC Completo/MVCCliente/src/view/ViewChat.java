package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.ControllerChat;

public class ViewChat extends JFrame{
	
	private JTextArea taMensajes;
	private JTextField tfEntrada;
	private JButton btnEnviar;
	private ControllerChat controller;
	
	public ViewChat() {
		super("Chat cliente");
		GridLayout layout = new GridLayout(0, 1);
		this.setLayout(layout);
		this.setSize(500,500);
		
		taMensajes = new JTextArea(5,1);
		tfEntrada = new JTextField();
		btnEnviar = new JButton("Enviar");
		
		this.add(taMensajes);
		this.add(tfEntrada);
		this.add(btnEnviar);
		
		controller = new ControllerChat(this);
	}

	public JTextArea getTaMensajes() {
		return taMensajes;
	}

	public JTextField getTfEntrada() {
		return tfEntrada;
	}

	public JButton getBtnEnviar() {
		return btnEnviar;
	}

	public ControllerChat getController() {
		return controller;
	}
	
	

}
