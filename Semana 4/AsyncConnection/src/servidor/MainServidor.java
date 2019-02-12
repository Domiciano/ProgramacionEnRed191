package servidor;

import java.util.Calendar;
import java.util.Scanner;

public class MainServidor {

	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());
		
		TCPConnection connection = TCPConnection.getInstance(5000);
		connection.waitForConnection();
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String mensaje = scanner.nextLine();
			connection.sendMessage(mensaje);
		}
		
	}

}
