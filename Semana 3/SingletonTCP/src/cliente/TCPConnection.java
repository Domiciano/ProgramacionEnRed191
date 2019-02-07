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
	
	private TCPConnection() {
		
	}
	
	public synchronized static TCPConnection getInstance() {
		if(instance == null) {
			instance = new TCPConnection();
		}
		return instance;
	}
	
	//Global
	private Socket socket;
	
	//Metodo del servidor
	public void waitForConnection(int port) {
		try {
			ServerSocket server = new ServerSocket(port);
			socket = server.accept();
		} catch (IOException e) {
			e.printStackTrace();
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
