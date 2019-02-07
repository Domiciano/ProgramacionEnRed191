import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class Main {
	
	public static void main(String...strings) {
		try {
			
			InetAddress google = InetAddress.getByName("www.icesi.edu.co");
			System.out.println(google.getHostAddress());
			
			InetAddress myAdd = InetAddress.getLocalHost();
			System.out.println(myAdd.getHostAddress());
			
			InetAddress[] group = InetAddress.getAllByName(myAdd.getCanonicalHostName());
			for(int i=0 ; i<group.length ; i++) {
				System.out.println(group[i].getHostAddress());
			}
			
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			while(interfaces.hasMoreElements()) {
				NetworkInterface interfaz = interfaces.nextElement();
				if(interfaz.isUp()) {
					System.out.println(interfaz.getName());
					for(InterfaceAddress address : interfaz.getInterfaceAddresses()) {
						System.out.println("\t" + address.getAddress().getHostAddress());	
					}
				}				
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
