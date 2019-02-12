package cliente;

import java.net.NetworkInterface;
import java.util.Scanner;

public class MainCliente {

	public static void main(String[] args) {
		TCPConnection connection  = TCPConnection.getInstance(0);
		connection.connect("127.0.0.1", 5000);
		
		
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String mensaje = scanner.nextLine();
			connection.sendMessage(mensaje);
		}

	}

}
