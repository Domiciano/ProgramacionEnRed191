package comm;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

import comm.TCPConnection.ConnectionObserver;

public class Connection {
	
	private Socket socket;
	private Receptor receptor;
	private Emisor emisor;
	private List<ConnectionObserver> observers;
	
	public Connection(Socket socket) {
		this.socket = socket;
	}
	
	public void defineObservers(List<ConnectionObserver> observers) {
		this.observers = observers;
	}

	public void initConnection() {
		try {
			receptor = new Receptor( this.socket.getInputStream() );
			receptor.defineObservers(this.observers);
			receptor.start();
			emisor = new Emisor( this.socket.getOutputStream() );
		}catch(IOException ex) {
			ex.printStackTrace();
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
