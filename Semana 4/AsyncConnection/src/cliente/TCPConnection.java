package cliente;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

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
			receptor = new Receptor(socket.getInputStream());
			receptor.start();
			emisor = new Emisor(socket.getOutputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Metodo del cliente
	public void connect(String ip, int port) {
		try {
			socket = new Socket(ip, port);
			receptor = new Receptor(socket.getInputStream());
			receptor.start();
			emisor = new Emisor(socket.getOutputStream());
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
	
	
	
	
	
	
	
	
	
	
	
	
}
