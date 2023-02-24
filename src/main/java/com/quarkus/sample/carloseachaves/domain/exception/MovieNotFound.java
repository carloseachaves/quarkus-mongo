package com.quarkus.sample.carloseachaves.domain.exception;

import java.util.NoSuchElementException;

import static java.lang.String.format;

public class MovieNotFound extends NoSuchElementException {

    public MovieNotFound(String id) {
        super(format("Movie not found %s", id));
    }
}
