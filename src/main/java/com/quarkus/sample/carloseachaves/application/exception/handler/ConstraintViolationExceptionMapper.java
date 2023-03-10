package com.quarkus.sample.carloseachaves.application.exception.handler;

import com.quarkus.sample.carloseachaves.application.exception.ResponseError;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.List;
import java.util.stream.Collectors;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {
        List<ResponseError.Violation> errorMessages = e.getConstraintViolations().stream()
                .map(constraintViolation -> new ResponseError.Violation(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage()))
                .collect(Collectors.toList());
        return Response.status(Response.Status.BAD_REQUEST).entity(new ResponseError(e.getMessage(), errorMessages)).build();
    }

}