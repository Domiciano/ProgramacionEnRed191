package Cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		try {
			//InetAddress address = InetAddress.getBy
			Socket beta = new Socket("127.0.0.1", 5000);
			
			//Recibir respuesta: 
			BufferedReader reader = new BufferedReader(new InputStreamReader(beta.getInputStream()));
			System.out.println("Esperando mensaje...");
			String line = reader.readLine();
			System.out.println("Mensaje entrante");
			System.out.println(line);
			
			//Mandar mensaje
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(beta.getOutputStream()));
			writer.println("Hola");
			writer.flush();
			System.out.println("Enviando: Hola");
			
		}catch (Exception e) {
			
		}
	}

}
