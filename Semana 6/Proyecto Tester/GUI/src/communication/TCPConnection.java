package communication;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPConnection {
	
	private static TCPConnection instance = null;
	
	private TCPConnection(int port) {
		try {
			server = new ServerSocket(port);
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public synchronized static TCPConnection getInstance(int port) {
		if(instance == null) {
			instance = new TCPConnection(port);
		}
		return instance;
	}
	
	public synchronized static TCPConnection getInstance() {
		return instance;
	}
	
	//Global
	private Socket socket;
	private ServerSocket server;
	private Receptor receptor;
	private Emisor emisor;
	
	//Metodo del servidor
	public void waitForConnection() {
		try {
			System.out.println("Esperando cliente");
			socket = server.accept();
			System.out.println("Cliente conectado!");
			receptor = new Receptor(socket.getInputStream(), listeners);
			receptor.start();
			emisor = new Emisor(socket.getOutputStream(), listeners);
			for(int i=0 ; i<listeners.size() ; i++) listeners.get(i).onConnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Metodo del cliente
	public void connect(String ip, int port) {
		try {
			socket = new Socket(ip, port);
			receptor = new Receptor(socket.getInputStream(), listeners);
			receptor.start();
			emisor = new Emisor(socket.getOutputStream(), listeners);
			for(int i=0 ; i<listeners.size() ; i++) listeners.get(i).onConnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public void sendMessage(String msj) {
		System.out.println("Enviando...");
		emisor.enviarMensaje(msj);
	}

	public void closeConnection() {
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public interface ConnectionListener{
		void onConnect();
		void onMessage(String msj);
	} 
	
	private List<ConnectionListener> listeners;
	
	public void addListener(ConnectionListener listener) {
		if(listeners == null) {
			listeners = new ArrayList<>();
		}
		listeners.add(listener);
	}
	
}