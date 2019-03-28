package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Genero;

public class SQLConnection {
	
	private static SQLConnection instance;
	
	private Connection conexion;
	private Statement statement;
	
	private SQLConnection() {
		try {
			//SET GLOBAL time_zone = '-5:00';
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine", "root", "");
			statement = conexion.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static synchronized SQLConnection getInstance() {
		if(instance == null) {
			instance = new SQLConnection();
		}
		return instance;
	}
	
	
	//CRUD
	public ArrayList<Genero> getAllGeneros(){
		ArrayList<Genero> output = new ArrayList<>();
		try {
			ResultSet resultados = statement.executeQuery("SELECT id,genero FROM generos");
			while (resultados.next()) {
				output.add(  new Genero(resultados.getInt(1) , resultados.getString(2))  );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
	
	public void createPelicula(String nombre, String pais, int generoId) {
		try {
			statement.execute("INSERT INTO peliculas(nombre,pais,generoId) VALUES('"+ nombre  +"','"+pais+"'," +generoId+ ")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getIdByGenero(String busqueda) {
		try {
			ResultSet resultado = statement.executeQuery("SELECT id FROM generos WHERE genero = '"+busqueda+"'");
			
			if(resultado.next()) {
				return resultado.getInt(1);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	
}