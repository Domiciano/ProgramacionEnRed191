package main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.text.DefaultCaret;

import main.Finder.BridgeConnection;

public class Principal extends JFrame implements BridgeConnection{
	
	JButton boton_buscar;
	JTextArea consola;
	JScrollPane scroller;
	
	public Principal() {
		setLayout(new GridLayout(0, 1));
		
		boton_buscar = new JButton("Buscar");
		boton_buscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Finder f  = new Finder();
				f.setBridgeConnection(Principal.this);
				f.start();
				
			}
		});
		
		
		consola = new JTextArea();
		scroller = new JScrollPane(consola);
		
		DefaultCaret caret = (DefaultCaret) consola.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		add(boton_buscar);
		add(scroller);
		
	}

	@Override
	public void onMessage(String msj) {
		consola.append(msj+"\n");
	}

}
