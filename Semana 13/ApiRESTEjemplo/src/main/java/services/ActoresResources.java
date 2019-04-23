package services;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import db.SQLConnection;
import entity.Actor;

@Stateless
@Path("actor")
public class ActoresResources {

	@GET
	@Path("echo")
	public String echo() {
		return "echo";
	}
	
	@GET
	@Path("find/{id}")
	@Produces("application/json")
	public Actor find(@PathParam("id") String id) {
		SQLConnection conexion = new SQLConnection();
		Actor actor = conexion.getActorByID(id);
		conexion.close();		
		return actor;
	}
	
	@POST
	@Consumes("application/json")
	public Actor create(Actor actor) {
		SQLConnection conexion = new SQLConnection();
		conexion.insertActor(actor);
		Actor out = conexion.getLastInsertedActor();
		conexion.close();
		return out;
	}
		
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	@Path("edit/{id}")
	public Actor edit(@PathParam("id") String id, Actor actor) {
		SQLConnection conexion = new SQLConnection();
		conexion.editActor(id, actor);
		Actor out = conexion.getActorByID(id);
		conexion.close();
		return out;
	}
	
}
