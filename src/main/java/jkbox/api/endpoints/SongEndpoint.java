package jkbox.api.endpoints;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jkbox.persistence.dao.PlaylistDAO;
import jkbox.persistence.dao.SongDAO;
import jkbox.persistence.models.Playlist;
import jkbox.persistence.models.Song;
import jkbox.services.youtube.MetadataModel;
import jkbox.services.youtube.YoutubeService;

@Path("/playlist/{id}/song")
public class SongEndpoint {
	public static SongDAO songDao = new SongDAO();
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") Long id, Song s) {
		// Busca os dados do video na API do YouTube
		MetadataModel mm = YoutubeService.getVideoInfo(s.getUrl());
		s.setTitle(mm.getTitle());
		s.setPlaying(false);
		
		// DAOs para criar o song dentro da playlist
		PlaylistDAO plDao = new PlaylistDAO();
		
		// Carrega a playlist
		Playlist pl = plDao.get(id);
		
		// Cria o som no banco
		songDao.create(s);
		
		// Adiciona o song na lista
		pl.getSongs().add(s);
		
		plDao.update(id, pl);
		
		//songDao.create(s);
		// Retorna o song preenchido
		return Response.status(Response.Status.CREATED).entity(s).build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		songDao.delete(id);
		return Response.status(Response.Status.NO_CONTENT).build();
	}
}
