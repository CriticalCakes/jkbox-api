package jkbox.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import jkbox.api.endpoints.PlaylistEndpoint;
import jkbox.api.endpoints.SongEndpoint;

@ApplicationPath("/api")
public class APIApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	public APIApplication() {
		singletons.add(new PlaylistEndpoint());
		singletons.add(new SongEndpoint());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}