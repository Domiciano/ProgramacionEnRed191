package comm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import comm.TCPConnection.ConnectionObserver;

public class Receptor extends Thread{
	private InputStream input;
	private boolean isAlive = true;
	private List<ConnectionObserver> observers;
	
	public Receptor(InputStream input) {
		this.input = input;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			while( isAlive ) {
				String line = reader.readLine();
				if(line ==  null) {
					input.close();
				}
				if(observers != null) for(int i=0 ; i<observers.size() ; i++) observers.get(i).onMessage(line);
				
			}
		}catch(IOException ex) {
			
		}
	}

	public void defineObservers(List<ConnectionObserver> observers) {
		this.observers = observers;	
	}

}
