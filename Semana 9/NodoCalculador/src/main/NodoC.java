package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class NodoC {

	static double total = 0;
	static int divisor = 1;

	static String id = UUID.randomUUID().toString();
	
	public static void main(String[] args) {
		try {
			InetAddress grupo = InetAddress.getByName("225.0.0.1");
			MulticastSocket socket = new MulticastSocket(5000);
			socket.joinGroup(grupo);
			
			new Thread(()->{
				while(true) {
					try {
						byte[] buf = new byte[1000];
						DatagramPacket packet = new DatagramPacket(buf, buf.length);
						socket.receive(packet);
						String recibido = new String(packet.getData()).trim();
												
						//ACTIVAR SECUENCIA DE LISTA
						if(recibido.equals("LIST")) {
							DatagramPacket list = new DatagramPacket(("NODE"+id).getBytes(), ("NODE"+id).getBytes().length, grupo, 5000);
							socket.send(list);
						}
						
						//PROMEDIO DELEGADO A CADA NODO
						if(recibido.startsWith(id)) {
							String[] data = recibido.split("::");
							double acu = 0;
							for(int i=1 ; i<data.length ; i++) {
								acu += Double.parseDouble(data[i]);
							}
							acu = (double)acu/(data.length-1);
							DatagramPacket sum = new DatagramPacket(("TOTAL::"+acu).getBytes(), ("TOTAL::"+acu).getBytes().length, grupo, 5000);
							socket.send(sum);
						}
											
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}) .start();
			
			while(true) {
				//Sólo es un nodo de cálculo
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
