package main;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("http://www.google.com/search?q=Prograred");
			HttpURLConnection conexion = (HttpURLConnection) url.openConnection(); 
			conexion.setRequestProperty("User-Agent", "Mozilla/5.0");
			
			
			int httpcode = conexion.getResponseCode();
			
			System.out.println(httpcode);
			
			
			InputStream is = conexion.getInputStream();
			
			
			byte[] buf = new byte[1024];
			int leidos = 0;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			
			while(   (leidos = is.read(buf)) != -1   ) {
				baos.write(buf, 0, leidos);
			}
			is.close();
			baos.close();
			
			
			String page = new String(  baos.toByteArray()  );
			System.out.println(page);
			System.out.println(  baos.toByteArray().length );
			
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

}
