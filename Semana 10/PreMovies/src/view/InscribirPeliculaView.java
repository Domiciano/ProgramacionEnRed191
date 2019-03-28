package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.InscribirPeliculaController;

public class InscribirPeliculaView extends JFrame {

	private JTextField fieldPelicula;
	private JButton btnAgregarPelicula;
	private JComboBox<String> comboActores;
	private JComboBox<String> comboPeliculas;
	private JComboBox<String> comboGenero;
	private JButton btnActoresAgregar;
	private JButton btnActoresEliminar;
	private JTextArea areaOutput;
	private InscribirPeliculaController controller;
	
	public InscribirPeliculaView() {
		super("Inscribir Película");
		setSize(700, 400);
		setLayout(new BorderLayout());
		
		JPanel panelPelicula = new JPanel();
		panelPelicula.setLayout(new GridLayout(1, 3));
		fieldPelicula = new JTextField();
		btnAgregarPelicula = new JButton("Registrar Película");
		comboGenero = new JComboBox<>();
		comboGenero.addItem("Seleccione el género");
		panelPelicula.add(fieldPelicula);
		panelPelicula.add(comboGenero);
		panelPelicula.add(btnAgregarPelicula);
		this.add(panelPelicula, BorderLayout.NORTH);
		
		JPanel panelActores = new JPanel();
		panelActores.setLayout(new GridLayout(0, 1));
		panelActores.add(new JLabel("Use esta sección para agregar actores a una pelicula de la lista"));
		comboPeliculas = new JComboBox<>();
		comboPeliculas.addItem("Seleccione Película");
		comboActores = new JComboBox<>();
		comboActores.addItem("Seleccione actores");
		btnActoresAgregar = new JButton("Agregar Actor");
		btnActoresEliminar = new JButton("Eliminar Actor");
		
		panelActores.add(comboPeliculas);
		JPanel subpanel = new JPanel();
		subpanel.setLayout(new GridLayout(1, 3));
		subpanel.add(comboActores);
		subpanel.add(btnActoresAgregar);
		subpanel.add(btnActoresEliminar);
		panelActores.add(subpanel);
		
		this.add(panelActores, BorderLayout.SOUTH);
		
		
		areaOutput = new JTextArea();
		this.add(areaOutput, BorderLayout.CENTER);
		
		controller = new InscribirPeliculaController(this);
	}

	//Getters
	
	public JTextField getFieldPelicula() {
		return fieldPelicula;
	}

	public JButton getBtnAgregarPelicula() {
		return btnAgregarPelicula;
	}

	public JComboBox<String> getComboActores() {
		return comboActores;
	}

	public JComboBox<String> getComboPeliculas() {
		return comboPeliculas;
	}

	public JComboBox<String> getComboGenero() {
		return comboGenero;
	}

	public JButton getBtnActoresAgregar() {
		return btnActoresAgregar;
	}

	public JButton getBtnActoresEliminar() {
		return btnActoresEliminar;
	}

	public JTextArea getAreaOutput() {
		return areaOutput;
	}
			
	
}
