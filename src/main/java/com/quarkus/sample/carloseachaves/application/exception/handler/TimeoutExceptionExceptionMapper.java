package com.quarkus.sample.carloseachaves.application.exception.handler;

import com.quarkus.sample.carloseachaves.application.exception.ResponseError;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.concurrent.TimeoutException;

@Provider
public class TimeoutExceptionExceptionMapper implements ExceptionMapper<TimeoutException> {

    @Override
    public Response toResponse(TimeoutException e) {

        return Response
                .status(Response.Status.GATEWAY_TIMEOUT)
                .entity(new ResponseError(e.getMessage())).build();
    }

}