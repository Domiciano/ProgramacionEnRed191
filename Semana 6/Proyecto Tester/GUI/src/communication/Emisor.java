package communication;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import communication.TCPConnection.ConnectionListener;

public class Emisor {
	private OutputStream out;
	private List<ConnectionListener> listeners;
	
	public Emisor(OutputStream out, List<ConnectionListener> listeners) {
		this.out = out;
		this.listeners = listeners;
	}
	
	public void enviarMensaje(String msj) {
		
		new Thread(){
			@Override
			public void run() {
				System.out.println("Hilo..." + msj);
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(out)));
				writer.println(msj);
				writer.flush();
			}
		}.start();
		
		/*
		new Thread( () -> {
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(new BufferedOutputStream(out)));
			writer.println(msj);
			writer.flush();
		}).start();
		*/
		
		
	}
	
}
