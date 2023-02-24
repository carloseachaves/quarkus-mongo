package com.quarkus.sample.carloseachaves.application.exception;

import java.util.List;


public class ConstraintViolationsResponseError {

    private final String message;
    private final List<Detail> details;

    public ConstraintViolationsResponseError(String message, List<Detail> details) {
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }
    public List<Detail> getDetails() {
        return details;
    }

    public static class Detail {

        private final String path;
        private final String message;

        public final String getPath() {
            return path;
        }
        public final String getMessage() {
            return message;
        }

        public Detail(String path, String message) {
            this.path = path;
            this.message = message;
        }

    }
}