package com.quarkus.sample.carloseachaves.domain.ports.in;

import com.quarkus.sample.carloseachaves.domain.entity.Movie;
import com.quarkus.sample.carloseachaves.domain.exception.ImpossibleObtainMovie;
import com.quarkus.sample.carloseachaves.domain.exception.MovieNotFound;

public interface ObtainMovieById {
    Movie get(String id) throws ImpossibleObtainMovie, MovieNotFound;
}
