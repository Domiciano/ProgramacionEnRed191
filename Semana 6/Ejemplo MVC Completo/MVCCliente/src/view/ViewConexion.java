package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControllerConexion;

public class ViewConexion extends JFrame{
	
	//Componentes
	private JLabel labelIntro;
	private JTextField tfIP;
	private JTextField tfPuerto;
	private JButton btnConectar;
	private ControllerConexion controller;
	
	public ViewConexion() {
		super("Conexión cliente");
		GridLayout layout = new GridLayout(0, 1);
		this.setLayout(layout);
		this.setSize(500,500);
		
		labelIntro = new JLabel("Por favor ingrese la dirección IP y "
				+ "el puerto para conectarse con un servidor");
		tfIP = new JTextField();
		tfPuerto = new JTextField();
		btnConectar = new JButton("Conectar");
		
		this.add(labelIntro);
		this.add(tfIP);
		this.add(tfPuerto);
		this.add(btnConectar);
		
		controller = new ControllerConexion(this);
	}
	
	
	//Metodos de acceso a los componentes
	public JLabel getLabelIntro() {
		return labelIntro;
	}

	public JTextField getTfIP() {
		return tfIP;
	}

	public JTextField getTfPuerto() {
		return tfPuerto;
	}

	public JButton getBtnConectar() {
		return btnConectar;
	}
	
	

}
