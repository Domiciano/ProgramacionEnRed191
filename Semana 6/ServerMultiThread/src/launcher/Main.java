package launcher;

import java.util.Scanner;

import comm.Connection;
import comm.TCPConnection;
import comm.TCPConnection.ConnectionEvent;

public class Main implements ConnectionEvent{

	private TCPConnection manager;
	
	public static void main(String[] args) {
		Main m = new Main();
		m.execute();
	}
	
	public void execute() {
		manager = TCPConnection.getInstance();
		manager.addConnectionEvent(this);
		
		new Thread(  ()->manager.waitForConnection(5000)  ).start();
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			//Broadcast
			String line = scanner.nextLine();
			manager.sendBroadcast(line);
		}
		
	}

	@Override
	public void onConnection() {
		System.out.println( "Clientes: " + manager.getClientsCount() );	
	}

	@Override
	public void onMessage(String uuid, String msj) {
		if(msj.equals("myid")) {
			manager.getConnectionById(uuid).sendMessage(uuid);
		}
		if(msj.contains("::")) {
			//Usando protocolo de mensaje directo
			String[] data = msj.split("::");
			manager.sendDirectMessage(uuid, data[0], data[1]);
		}
		
	}

}
