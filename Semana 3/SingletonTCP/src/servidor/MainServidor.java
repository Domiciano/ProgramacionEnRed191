package servidor;

public class MainServidor {

	public static void main(String[] args) {
		TCPConnection conexion = TCPConnection.getInstance();
		
		while(true) {
			conexion.waitForConnection(5000);
			System.out.println("Conexion Aceptada");
			String mensaje = conexion.waitForAMessage();
			System.out.println("Recibido: "+mensaje);
		}
		
		
	}

}
