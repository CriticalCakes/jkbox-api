package jkbox.api.endpoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jkbox.persistence.dao.PlaylistDAO;
import jkbox.persistence.models.Playlist;

@Path("/playlist")
public class PlaylistEndpoint {
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Playlist p) {
		PlaylistDAO dao = new PlaylistDAO();
		dao.create(p);
		return Response.status(201).entity(p).build();
	}
	
	public void update(Long id) {
		
	}
	
	public void delete(Long id) {
		
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public Response get(@QueryParam("name") String nome) {
		String hello = "Hello " + nome;
		return Response.status(200).entity(hello).build();
	}
	
	public void getAll() {
		
	}
}
