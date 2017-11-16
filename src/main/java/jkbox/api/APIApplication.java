package jkbox.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import jkbox.api.endpoints.PlaylistEndpoint;

@ApplicationPath("/api")
public class APIApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();

	public APIApplication() {
		singletons.add(new PlaylistEndpoint());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}