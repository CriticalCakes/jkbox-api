package jkbox.services.youtube;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;


public class YoutubeService {
	
	private static String uri = "http://www.youtube.com/oembed?url=";
	
	/**
	 * Recebe uma url preenchida e busca os metadados na 
	 * API do YouTube. Se o video é encontrado com sucesso,
	 * os metadados sãa preenchidos no obejto MetadataModel. 
	 * 
	 * @param s String URL válida do YouTube
	 * @return metadata MetadataModel YouTube video Meta Data
	 */
	public static MetadataModel getVideoInfo(String url) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget target = client.target(YoutubeService.uri + url);
        Response response = target.request().get();
        
        if (response.getStatus() != 200)
        		return null; //TODO lançar um exceção, não foi possível consultar a API
        
        MetadataModel metadata = response.readEntity(MetadataModel.class);
        response.close();
        
        return metadata;
	}

}
