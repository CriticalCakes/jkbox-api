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

import jkbox.exceptions.PlaylistAlreadyExists;
import jkbox.exceptions.PlaylistNotFoundException;
import jkbox.persistence.dao.PlaylistDAO;
import jkbox.persistence.models.Playlist;

@Path("/playlist")
/**
 * Interface pública de um WebService para manipulação de Playlists utilizando JSON.
 * @author Lincon Dias e Pedro Henrique Fernandes
 *
 */
public class PlaylistEndpoint {
	
	private static PlaylistDAO dao = new PlaylistDAO();
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * Cria uma nova playlist.
	 * @param p Playlist entidade preenchida pelo resteasy.
	 * @return Response código de estado HTTP. 201 success, 400 fail. 
	 */
	public Response create(Playlist p) {
		try {
			Playlist created = dao.create(p);
			return Response.status(Response.Status.CREATED).entity(created).build();
		}
		catch(PlaylistAlreadyExists e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		}
	}
	
	@POST
	@Path("/{id}/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * Edita uma Playlist especificada pelo id.
	 * @param id Long id da Playlist que será editada. 
	 * @param pl Playlist é uma entidade preenchida com novos dados.
	 * @return Response código de estado HTTP. 200 success, 400 fail.
	 */
	public Response update(@PathParam("id") Long id, Playlist pl) {
		try {
			Playlist updated = dao.update(id, pl);
			return Response.status(Response.Status.OK).entity(updated).build();
		}
		catch(PlaylistNotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e).build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	/**
	 * Exclui uma Playlist especificada pelo id.
	 * @param id Long id da Playlist que será excluída.
	 * @return Response código de estado HTTP. 204 success, 400 fail.
	 */
	public Response delete(@PathParam("id")Long id) {
		try {
			dao.delete(id);			
		}
		catch(PlaylistNotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e).build();
		}
		return Response.status(Response.Status.NO_CONTENT).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * Retorna os dados de uma Playlist especificada pelo id. 
	 * @param id Long id da Playlist que será retornada.
	 * @return Response código de estado HTTP. 200 success, 400 fail.
	 */
	public Response get(@PathParam("id") Long id) {
		try {
			Playlist pl = dao.get(id);
			return Response.status(Response.Status.OK).entity(pl).build();
		}
		catch(PlaylistNotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(e).build();
		}
	}
}
