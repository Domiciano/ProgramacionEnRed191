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
	private ControllerConexion controller;
	
	public ViewConexion() {
		super("Conexión cliente");
		GridLayout layout = new GridLayout(0, 1);
		this.setLayout(layout);
		this.setSize(500,500);
		
		labelIntro = new JLabel("Esperando conexión...");
		
		this.add(labelIntro);
		
		controller = new ControllerConexion(this);
	}
	
	
	//Metodos de acceso a los componentes
	public JLabel getLabelIntro() {
		return labelIntro;
	}	

}
