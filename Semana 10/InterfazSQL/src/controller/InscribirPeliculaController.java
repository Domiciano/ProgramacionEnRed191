package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import db.SQLConnection;
import model.Genero;
import view.InscribirGeneroView;
import view.InscribirPeliculaView;

public class InscribirPeliculaController implements ActionListener{

	private InscribirPeliculaView view;
	
	public InscribirPeliculaController(InscribirPeliculaView view) {
		this.view = view;
		init();
	}
	
	public void init() {
		cargarInfoGeneros();
		
		view.getBtnAgregarPelicula().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre = view.getFieldPelicula().getText();
				int id = SQLConnection.getInstance().getIdByGenero(  (String) view.getComboGenero().getSelectedItem()  );
				SQLConnection.getInstance().createPelicula(nombre, "Colombia", id);
			}
		});
	}
	
	private void cargarInfoGeneros() {
		ArrayList<Genero> generos = SQLConnection.getInstance().getAllGeneros();
		
		
		
		view.getComboGenero().removeAllItems();
		
		view.getComboGenero().addItem("Seleccione un genero");
		for(int i=0 ; i<generos.size() ; i++) {
			view.getComboGenero().addItem(generos.get(i).getGenero());
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
