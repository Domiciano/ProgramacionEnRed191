package main;

import java.net.InetAddress;
import java.net.NetworkInterface;

public class Finder extends Thread{
	//Clase observada
	
	
	//1. Crear interfaz
	public interface BridgeConnection {
		void onMessage(String msj);
	}
	
	
	//2. Crear instancia
	BridgeConnection connection;
	
	//3. Hacer método set del objeto
	public void setBridgeConnection(BridgeConnection connection) {
		this.connection = connection;
	}
	
	
	@Override
	public void run() {
		try {
			InetAddress address = InetAddress.getLocalHost();
			String local = address.getHostAddress();
			System.out.println(local);
			NetworkInterface myNI = NetworkInterface.getByInetAddress(address);
			System.out.println(myNI.getInterfaceAddresses().get(0).getNetworkPrefixLength());
			
			String[] ip = local.split("\\.");
			for(int i=164 ; i<256 ; i++) {
				for(int j=1; j<256 ; j++) {
					InetAddress addi = InetAddress.getByName(ip[0]+"."+ip[1]+"."+i+"."+j);
					System.out.println("->"+ip[0]+"."+ip[1]+"."+i+"."+j);
					connection.onMessage("->"+ip[0]+"."+ip[1]+"."+i+"."+j);
					if(addi.isReachable(500)) {
						System.out.println("<<<"+addi.getHostName()+">>>");
						connection.onMessage("<<<"+addi.getHostName()+">>>");
					}
				}
			}
		}catch (Exception e) {
			
		}
	}
}
