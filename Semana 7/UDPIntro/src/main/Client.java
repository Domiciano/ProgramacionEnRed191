package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client {

	
	
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket();
			
			String mensaje = "Hola desde UDP";
			
			DatagramPacket packet = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, InetAddress.getByName("127.0.0.1"), 5000);
			
			socket.send(packet);
			
			System.out.println("Enviado!");
			
			
			DatagramSocket receptor = new DatagramSocket(6000);
			byte[] buffer = new byte[1024];
			DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
			receptor.receive(respuesta);
			
			System.out.println(new String(respuesta.getData()));
			
			
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
