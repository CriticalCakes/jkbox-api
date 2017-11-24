package jkbox.api.endpoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jkbox.persistence.dao.PlaylistDAO;
import jkbox.persistence.models.Playlist;

@Path("/playlist")
public class PlaylistEndpoint {
	
	private static PlaylistDAO dao = new PlaylistDAO();
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Playlist p) {
		Playlist created = dao.create(p);
		return Response.status(Response.Status.CREATED).entity(created).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id, Playlist pl) {
		Playlist updated = dao.update(id, pl);
		return Response.status(Response.Status.OK).entity(updated).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id")Long id) {
		dao.delete(id);
		return Response.status(Response.Status.NO_CONTENT).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") Long id) {
		Playlist pl = dao.get(id);
		return Response.status(Response.Status.OK).entity(pl).build();
	}
}
