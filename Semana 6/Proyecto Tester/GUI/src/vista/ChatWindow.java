package vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import control.ChatController;

public class ChatWindow extends JFrame{
	
	private JTextArea area;
	private JTextField tfInput;
	private JButton sendButton;
	private ChatController controller;
	
	public ChatWindow() {
		super("Chat");
		area = new JTextArea(5, 1);
		tfInput = new JTextField();
		sendButton = new JButton("Enviar");
		
		GridLayout layout = new GridLayout(0, 1);
		setLayout(layout);
		
		add(area);
		add(tfInput);
		add(sendButton);
		setSize(500,500);
		controller = new ChatController(this);
	}

	public JTextArea getArea() {
		return area;
	}

	public void setArea(JTextArea area) {
		this.area = area;
	}

	public JTextField getTfInput() {
		return tfInput;
	}

	public void setTfInput(JTextField tfInput) {
		this.tfInput = tfInput;
	}

	public JButton getSendButton() {
		return sendButton;
	}

	public void setSendButton(JButton sendButton) {
		this.sendButton = sendButton;
	}

}
