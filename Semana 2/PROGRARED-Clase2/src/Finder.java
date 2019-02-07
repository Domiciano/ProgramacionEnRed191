import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;

public class Finder {

	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getLocalHost();
			String local = address.getHostAddress();
			System.out.println(local);
			NetworkInterface myNI = NetworkInterface.getByInetAddress(address);
			System.out.println(myNI.getInterfaceAddresses().get(0).getNetworkPrefixLength());
			
			
			String[] ip = local.split("\\.");
			for(int i=1 ; i<256 ; i++) {
				for(int j=208 ; j<256 ; j++) {
					InetAddress addi = InetAddress.getByName(ip[0]+"."+ip[1]+"."+i+"."+j);
					System.out.println("->"+ip[0]+"."+ip[1]+"."+i+"."+j);
					if(addi.isReachable(500)) System.out.println("<<<"+addi.getHostName()+">>>");
				}
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
