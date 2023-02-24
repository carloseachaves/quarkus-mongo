package com.quarkus.sample.carloseachaves.application.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


public class ResponseError {

    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<Violation> violations;

    public ResponseError(String message, List<Violation> details) {
        this.message = message;
        this.violations = details;
    }

    public ResponseError(String message) {
        this.message = message;
        this.violations = null;
    }

    public String getMessage() {
        return message;
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public static class Violation {

        private final String path;
        private final String message;

        public final String getPath() {
            return path;
        }

        public final String getMessage() {
            return message;
        }

        public Violation(String path, String message) {
            this.path = path;
            this.message = message;
        }

    }
}