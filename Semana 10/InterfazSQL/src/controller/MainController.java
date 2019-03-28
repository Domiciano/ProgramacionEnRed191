package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.InscribirActorView;
import view.InscribirGeneroView;
import view.InscribirPeliculaView;
import view.MainView;

public class MainController implements ActionListener{

	private MainView view;
	
	public MainController(MainView view) {
		this.view = view;
		init();
	}
	
	public void init() {
		view.getBtnInscribirActor().addActionListener(this);
		view.getBtnInscribirGenero().addActionListener(this);
		view.getBtnInscribirPelicula().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(view.getBtnInscribirActor())) {
			InscribirActorView window = new InscribirActorView();
			window.setVisible(true);
		}
		
		else if(e.getSource().equals(view.getBtnInscribirGenero())) {
			InscribirGeneroView window = new InscribirGeneroView();
			window.setVisible(true);
		}
		
		else if(e.getSource().equals(view.getBtnInscribirPelicula())) {
			InscribirPeliculaView window = new InscribirPeliculaView();
			window.setVisible(true);
		}
	}
	
}
