package communication;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Emisor {
	private OutputStream out;
	
	public Emisor(OutputStream out) {
		this.out = out;
	}
	
	public void enviarMensaje(String msj) {
		
		new Thread(){
			@Override
			public void run() {
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
