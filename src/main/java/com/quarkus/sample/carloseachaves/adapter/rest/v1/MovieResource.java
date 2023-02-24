package com.quarkus.sample.carloseachaves.adapter.rest.v1;

import com.quarkus.sample.carloseachaves.service.MovieService;
import org.jboss.resteasy.reactive.RestPath;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/movies")
public class MovieResource {

    @Inject
    MovieService movieService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public String getById(@RestPath String id) {
        return movieService.getById(id);
    }
}
