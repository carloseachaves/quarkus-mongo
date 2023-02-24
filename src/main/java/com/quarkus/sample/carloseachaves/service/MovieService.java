package com.quarkus.sample.carloseachaves.service;

import com.quarkus.sample.carloseachaves.domain.entity.Movie;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.TimeoutException;

@ApplicationScoped
public class MovieService {

    //TODO
    public Movie getById(String id) throws TimeoutException {
        return new Movie(id, "carlos");
    }

}
