package com.quarkus.sample.carloseachaves.application.exception.handler;

import com.quarkus.sample.carloseachaves.application.exception.ResponseError;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.NoSuchElementException;

@Provider
public class NoSuchElementExceptionExceptionMapper implements ExceptionMapper<NoSuchElementException> {

    @Override
    public Response toResponse(NoSuchElementException e) {

        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(new ResponseError(e.getMessage())).build();
    }

}