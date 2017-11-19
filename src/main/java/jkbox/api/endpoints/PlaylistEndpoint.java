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
import jkbox.services.youtube.MetadataModel;
import jkbox.services.youtube.YoutubeService;

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
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@QueryParam("url") String url) {
		MetadataModel mm = YoutubeService.getVideoInfo(url);
		return Response.status(200).entity(mm).build();
	}
	
	public void getAll() {
		
	}
}
