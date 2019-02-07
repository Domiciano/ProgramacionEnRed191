import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 5000);
			System.out.println("Conexion Aceptada");
			
			File f = new File("D:/Usuarios/1143848922/Desktop/ma.png");
			
			FileInputStream input = new FileInputStream(f);
			BufferedOutputStream output = new BufferedOutputStream(socket.getOutputStream());
			
			
			int numBytes = 0;
			byte[] buffer = new byte[1024];
			while( (numBytes = input.read(buffer)) != -1 ) {
				output.write(buffer, 0, numBytes);
				output.flush();
			}
			
			input.close();
			
			
			
			while(true) {
				
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
