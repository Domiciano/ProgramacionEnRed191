package communication;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import communication.TCPConnection.ConnectionEvent;

public class Receptor extends Thread{
	private InputStream input;
	private boolean isAlive = true;
	private List<ConnectionEvent> listeners;
	
	public Receptor(InputStream input, List<ConnectionEvent> listeners) {
		this.input = input;
		this.listeners = listeners;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			while( isAlive ) {
				String line = reader.readLine();
				//Detectamos la desconexi
				if(line ==  null) {
					input.close();
				}
				System.out.println(">>Receptor: " + line);
				for(int i=0 ; i<listeners.size() ; i++) listeners.get(i).onMessage(line);
			}
		}catch(IOException ex) {
			
		}
	}

}
