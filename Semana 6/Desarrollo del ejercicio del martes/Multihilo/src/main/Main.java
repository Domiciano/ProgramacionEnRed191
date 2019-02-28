package main;

import java.util.Scanner;

import comm.TCPConnection;
import comm.TCPConnection.ConnectionObserver;

public class Main implements ConnectionObserver{

	TCPConnection connection;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.execute();
	}

	private void execute() {
		//Esperamos por clientes en un worker thread
		new Thread(()-> {
			connection = TCPConnection.getInstance();
			connection.addObserver(this);
			connection.waitForConnection(5000);	
		}).start();
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String line = scanner.nextLine();
			connection.sendBroadcast(line);
		}
	
	}

	@Override
	public void onConnection() {
		System.out.println("Cliente conectado!");
		System.out.println("Clientes: " + connection.getClientCount() );
	}

	@Override
	public void onMessage(String msj) {
		System.out.println("Recibido>> " + msj);	
	}

}
