package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {

	public static void main(String[] args) {
		
		try {
			//En erl servidor se especifica el puerto en el que vamos a escuchar
			DatagramSocket socket = new DatagramSocket(5000);
			
			byte[] buffer = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			
			System.out.println("Recibiendo...");
			//Freezes the loop
			socket.receive(packet);
			System.out.println("Recibido!");
			String recibido = new String(packet.getData());
			
			System.out.println(recibido);
			
			Thread.sleep(1000);
			
			String respuesta = "Todo bien";
			socket.send(new DatagramPacket(respuesta.getBytes(), respuesta.getBytes().length, packet.getAddress(), 6000));
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
