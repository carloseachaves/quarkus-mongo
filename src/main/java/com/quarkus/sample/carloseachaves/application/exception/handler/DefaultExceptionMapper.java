package com.quarkus.sample.carloseachaves.application.exception.handler;

import com.quarkus.sample.carloseachaves.application.exception.ResponseError;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DefaultExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable e) {

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ResponseError(e.getMessage()))
                .build();

    }

}