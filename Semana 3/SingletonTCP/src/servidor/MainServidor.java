package servidor;

public class MainServidor {

	public static void main(String[] args) {
		TCPConnection conexion = TCPConnection.getInstance(5000);
		
		while (true) {
			conexion.waitForConnection();
			System.out.println("Conexion Aceptada");
			while(true) {
				String mensaje = conexion.waitForAMessage();
				System.out.println("Recibido: "+mensaje);
				if(mensaje == null) {
					System.out.println("El cliente se ha desconectado!");
					conexion.closeConnection();
					break;
				}
			}
		}
	}

}
