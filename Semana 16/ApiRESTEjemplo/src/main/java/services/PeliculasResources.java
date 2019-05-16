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
import entity.Pelicula;

@Stateless
@Path("pelicula")
public class PeliculasResources {

	@GET
	@Path("echo")
	public String echo() {
		return "echo";
	}
	
	@GET
	@Path("find/{id}")
	@Produces("application/json")
	public Pelicula find(@PathParam("id") String id) {
		return null;
	}
	
	@POST
	@Consumes("application/json")
	public Pelicula create(Pelicula pelicula) {
		return null;
	}
		
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	@Path("edit/{id}")
	public Pelicula edit(@PathParam("id") String id, Pelicula pelicula) {
		return null;
	}
	
}
