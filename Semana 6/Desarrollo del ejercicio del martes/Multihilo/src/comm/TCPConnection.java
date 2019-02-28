package comm;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import main.Main;

public class TCPConnection {
	
	//Estructura Singleton
	private static TCPConnection instance = null;
	
	private TCPConnection() {
		connections = new ArrayList<>();	
	}
	
	public synchronized static TCPConnection getInstance() {
		if(instance == null) {
			instance = new TCPConnection();
		}
		return instance;
	}
	
	//Variables Globales
	private ServerSocket server;
	private boolean serverAlive = true;
	private List<Connection> connections;
	private List<ConnectionObserver> observers;

	
	public void waitForConnection(int port) {
		try {
			server = new ServerSocket(port);			
			while (serverAlive) {
				System.out.println("Esperando cliente");
				Socket socket = server.accept();
				System.out.println("Cliente conectado!");
				Connection connection = new Connection(socket);
				connection.defineObservers(observers);
				connection.initConnection();
				addClient(connection);
				if(observers != null) for(int i=0 ; i<observers.size() ; i++) observers.get(i).onConnection();
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void addClient(Connection connection) {
		if(connections == null) {
			connections = new ArrayList<>();
		}		
		connections.add(connection);
	}

	
	//Patrón Observer
	public interface ConnectionObserver {
		void onConnection();
		void onMessage(String msj);
	}
	
	public void addObserver(ConnectionObserver observer) {
		if(observers == null) {
			observers = new ArrayList<>();
		}
		observers.add(observer);
		
	}

	public int getClientCount() {
		return connections.size();
	}

	public void sendBroadcast(String line) {
		for(int i=0 ; i<connections.size() ; i++) {
			connections.get(i).sendMessage(line);
		}		
	}
	

}