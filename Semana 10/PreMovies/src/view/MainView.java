package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.MainController;

public class MainView extends JFrame{
	
	private JButton btnInscribirPelicula;
	private JButton btnInscribirActor;
	private JButton btnInscribirGenero;
	private JButton btnBuscar;
	private JTextField fieldBusqueda;
	private JTextArea areaOutput;
	private MainController controller;
	
	public MainView() {
		super("Inscripción de películas");
		//GridLayout layout = new GridLayout(0, 1);
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		setSize(500, 700);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));
		btnInscribirPelicula = new JButton("Inscribir Película");
		panel.add(btnInscribirPelicula);
		btnInscribirActor = new JButton("Inscribir Actor");
		panel.add(btnInscribirActor);
		btnInscribirGenero = new JButton("Inscribir Género");
		panel.add(btnInscribirGenero);
		
		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setLayout(new BorderLayout());
		btnBuscar = new JButton("Buscar");
		panelBusqueda.add(btnBuscar, BorderLayout.EAST);
		fieldBusqueda = new JTextField();
		panelBusqueda.add(fieldBusqueda);
		
		panel.add(panelBusqueda);
		
		areaOutput = new JTextArea(30,1);
		areaOutput.setBounds(0,0,WIDTH, HEIGHT/3);
		
		this.add(panel, BorderLayout.NORTH);
		this.add(areaOutput);
		
		controller = new MainController(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	//Getters and setters
	
	public JButton getBtnInscribirPelicula() {
		return btnInscribirPelicula;
	}

	public void setBtnInscribirPelicula(JButton btnInscribirPelicula) {
		this.btnInscribirPelicula = btnInscribirPelicula;
	}

	public JButton getBtnInscribirActor() {
		return btnInscribirActor;
	}

	public void setBtnInscribirActor(JButton btnInscribirActor) {
		this.btnInscribirActor = btnInscribirActor;
	}

	public JButton getBtnInscribirGenero() {
		return btnInscribirGenero;
	}

	public void setBtnInscribirGenero(JButton btnInscribirGenero) {
		this.btnInscribirGenero = btnInscribirGenero;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JTextField getFieldBusqueda() {
		return fieldBusqueda;
	}

	public void setFieldBusqueda(JTextField fieldBusqueda) {
		this.fieldBusqueda = fieldBusqueda;
	}

	public JTextArea getAreaOutput() {
		return areaOutput;
	}

	public void setAreaOutput(JTextArea areaOutput) {
		this.areaOutput = areaOutput;
	}
	
	
	

}
