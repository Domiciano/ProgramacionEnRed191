package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Actor;

public class SQLConnection {
	
	private Connection conexion;
	private Statement statement;
	
	public SQLConnection() {
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

	public Actor getActorByID(String id) {
		Actor actor = new Actor("0", "null");
		try {
			ResultSet resultados = statement.executeQuery("SELECT * FROM actores WHERE id="+id);
			
			if(resultados.next()) {
				int actorId = resultados.getInt(1);
				String nombre =  resultados.getString(2);
				actor = new Actor(""+actorId, nombre);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actor;
	}

	public void close() {
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public void insertActor(Actor actor) {
		try {
			statement.execute("INSERT INTO actores(nombre) VALUES ('"+actor.getNombre()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void editActor(String id, Actor actor) {
		try {
			statement.execute("UPDATE actores SET nombre='"+actor.getNombre()+"' WHERE id="+id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Actor getLastInsertedActor() {
		Actor actor = new Actor("0", "null");
		try {
			ResultSet resultados = statement.executeQuery("SELECT * FROM actores WHERE id=LAST_INSERT_ID()");			
			if(resultados.next()) {
				int actorId = resultados.getInt(1);
				String nombre =  resultados.getString(2);
				actor = new Actor(""+actorId, nombre);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return actor;
	}

}