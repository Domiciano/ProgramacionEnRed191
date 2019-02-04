package Servidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;

public class Servidor {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(5000);
			
			System.out.println("Esperando conexión");
			Socket alfa = server.accept();
			System.out.println("Conexión aceptada");
			
			//Responder mensaje
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(alfa.getOutputStream()));
			writer.println("¿Como estas?");
			writer.flush();
			System.out.println("Enviando: Como estás");
			
			//Recepción de datos: 
			BufferedReader reader = new BufferedReader(new InputStreamReader(alfa.getInputStream()));
			String line = reader.readLine();
			System.out.println(line);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
