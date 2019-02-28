package comm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import comm.TCPConnection.ConnectionEvent;

public class Receptor extends Thread{
	private String uuid;
	private InputStream input;
	private boolean isAlive = true;
	private List<ConnectionEvent> listeners;
	
	public Receptor(InputStream input) {
		this.input = input;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
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
				for(int i=0 ; i<listeners.size() ; i++) listeners.get(i).onMessage(uuid, line);
			}
		}catch(IOException ex) {
			
		}
	}

	public void defineListeners(List<ConnectionEvent> listeners) {
		this.listeners = listeners;
	}

}
