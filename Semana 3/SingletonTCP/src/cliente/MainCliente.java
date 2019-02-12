package cliente;

public class MainCliente {

	public static void main(String[] args) {
		TCPConnection conexion = TCPConnection.getInstance(0);
		conexion.connect("127.0.0.1", 5000);
		System.out.println("Conectado!");
		
		conexion.sendMessage("Hola desde Singleton");
		conexion.closeConnection();
		
		while(true) {}

	}

}
