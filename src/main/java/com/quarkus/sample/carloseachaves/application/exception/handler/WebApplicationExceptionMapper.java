package com.quarkus.sample.carloseachaves.application.exception.handler;

import com.quarkus.sample.carloseachaves.application.exception.ResponseError;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

    @Override
    public Response toResponse(WebApplicationException e) {
        return Response.fromResponse(e.getResponse())
                .entity(new ResponseError(e.getMessage()))
                .build();
    }

}