package services;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Stateless
@Path("first")
public class First {

	@GET
	@Path("echo")
	public String echo() {
		return "echo";
	}
	
}
