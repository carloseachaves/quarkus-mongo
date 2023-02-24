package com.quarkus.sample.carloseachaves.adapter.rest.v1;

import com.quarkus.sample.carloseachaves.domain.entity.Movie;
import com.quarkus.sample.carloseachaves.service.MovieService;
import org.jboss.resteasy.reactive.RestPath;

import javax.inject.Inject;
import javax.validation.constraints.Size;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.TimeoutException;

@Path("/v1/movies")
public class MovieResource {

    @Inject
    MovieService movieService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getById(@RestPath @Size(min = 8, max = 8) String id) throws TimeoutException {
        Movie movie = movieService.getById(id);
        return Response
                .status(Response.Status.OK)
                .entity(movie)
                .build();
    }
}
