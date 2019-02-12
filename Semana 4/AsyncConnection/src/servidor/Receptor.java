package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Receptor extends Thread{
	private InputStream input;
	private boolean isAlive = true;
	
	public Receptor(InputStream input) {
		this.input = input;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			while( isAlive ) {
				String line = reader.readLine();
				
				
				//Detectamos la desconexión
				if(line ==  null) {
					input.close();
				}
				System.out.println(line);
				
			}
		}catch(IOException ex) {
			
		}
	}

}
