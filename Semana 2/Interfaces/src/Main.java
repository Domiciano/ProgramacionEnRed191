import java.io.IOException;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		try {
			Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
			
			while(nis.hasMoreElements()) {
				NetworkInterface networki = nis.nextElement();
				if( networki.isUp() ) {
					System.out.println(networki.getName());
					List<InterfaceAddress> list = networki.getInterfaceAddresses();
					for(int i=0 ; i<list.size() ; i++) {
						System.out.println("\t"+list.get(i).getAddress().getHostAddress());
					}
				}
			}
			
			InetAddress myAddress = InetAddress.getLocalHost();
			System.out.println( myAddress.getHostAddress() );
			System.out.println( myAddress.getHostName() );
			NetworkInterface net = NetworkInterface.getByInetAddress(myAddress);
			System.out.println("Network prefix: "+net.getInterfaceAddresses().get(0).getNetworkPrefixLength());
			
			
			
			InetAddress velez = InetAddress.getByName("172.30.192.21");
			System.out.println(velez.isReachable(500));
			
			InetAddress cristian = InetAddress.getByName("172.30.180.27"); //ICMP Request
			System.out.println(cristian.isReachable(500));
			
			
			InetAddress icesi = InetAddress.getByName("www.icesi.edu.co"); //DNS Request
			System.out.println( icesi.getHostAddress() );
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
