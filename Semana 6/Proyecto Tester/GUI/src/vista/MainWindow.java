package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.MainController;

public class MainWindow extends JFrame{

	private JLabel label;
	private JTextField tf_ip;
	private JTextField tf_port;
	private JButton btnConectar;	
	private MainController controller;
	
	public MainWindow() {
		super("Conexión TCP");
		
		label = new JLabel("Inscriba los datos para conectarse a un host");
		tf_ip = new JTextField();
		tf_port = new JTextField();
		btnConectar = new JButton("Conectar");
		
		
		GridLayout layout = new GridLayout(0, 1);
		setLayout(layout);
		add(label);
		add(tf_ip);
		add(tf_port);
		add(btnConectar);
		setSize(500,500);
		
		controller = new MainController(this);
	}


	public JLabel getLabel() {
		return label;
	}


	public void setLabel(JLabel label) {
		this.label = label;
	}


	public JTextField getTf_ip() {
		return tf_ip;
	}


	public void setTf_ip(JTextField tf_ip) {
		this.tf_ip = tf_ip;
	}


	public JTextField getTf_port() {
		return tf_port;
	}


	public void setTf_port(JTextField tf_port) {
		this.tf_port = tf_port;
	}


	public JButton getBtnConectar() {
		return btnConectar;
	}


	public void setBtnConectar(JButton btnConectar) {
		this.btnConectar = btnConectar;
	}
	
	
	
	
}
