package servidor;

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
	
	//Metodo del servidor
	public void waitForConnection() {
		try {
			System.out.println("Esperando cliente");
			socket = server.accept();
			System.out.println("Cliente conectado!");
		} catch (IOException e) {
			System.out.println(">>>" + e.getMessage());
		}
	}
	
	//Metodo del cliente
	public void connect(String ip, int port) {
		try {
			socket = new Socket(ip, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String waitForAMessage() {
		try {
			if(socket!=null) {	
					BufferedReader reader = new BufferedReader(new InputStreamReader (socket.getInputStream()) );
					return reader.readLine();
			}else {
				System.out.println("Primero necesita conectarse!");
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public void sendMessage(String msj) {
		try {
			if(socket != null) {
				PrintWriter writer = new PrintWriter(new BufferedOutputStream(socket.getOutputStream()));
				writer.println(msj);
				writer.flush();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
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
