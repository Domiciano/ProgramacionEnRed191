import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(5000);
			Socket socket = server.accept();
			System.out.println("Conectado!");
			
			//Recibir archivo
			BufferedInputStream input = new BufferedInputStream(socket.getInputStream());
			FileOutputStream output = new FileOutputStream(new File("D:/Usuarios/1143848922/Desktop/ma_transfer.png"));
			
			int numBytes = 0;
			byte[] buffer = new byte[1024];
			while( (numBytes = input.read(buffer)) != -1 ) {
				output.write(buffer, 0, numBytes);
				output.flush();
			}
			
			output.close();
			
			
			while(true) {
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
