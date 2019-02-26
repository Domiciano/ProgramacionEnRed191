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
	public void waitForConnection(int port) {
		try {
			System.out.println("Esperando cliente");
			socket = server.accept();
			System.out.println("Cliente conectado!");
			if(listeners == null) listeners = new ArrayList<>();
			receptor = new Receptor(socket.getInputStream(), listeners);
			receptor.start();
			emisor = new Emisor(socket.getOutputStream());
			
			for(int i=0 ; i<listeners.size() ; i++) listeners.get(i).onConnection();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Metodo del cliente
	public void connect(String ip, int port) {
		try {
			socket = new Socket(ip, port);
			System.out.println("Conectado!");
			if(listeners == null) listeners = new ArrayList<>();
			receptor = new Receptor(socket.getInputStream(), listeners);
			receptor.start();
			emisor = new Emisor(socket.getOutputStream());
			
			for(int i=0 ; i<listeners.size() ; i++) listeners.get(i).onConnection();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public void sendMessage(String msj) {
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
	
	//Hacer la clase sea observable
	public interface ConnectionEvent{
		void onConnection();
		void onMessage(String msj);
	}
	
	private List<ConnectionEvent> listeners;
	
	public void addConnectionEvent(ConnectionEvent listener) {
		if(listeners == null) {
			listeners = new ArrayList<>();
		}
		listeners.add(listener);
	}
	
	
	
	
	
	
	
}
