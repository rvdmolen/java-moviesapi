package com.codingmill.moviesapi.web.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoviesAPITechnicalException extends RuntimeException {
    Logger logger = LoggerFactory.getLogger(MoviesAPITechnicalException.class);

    public MoviesAPITechnicalException(String message) {
        super(message);
        this.logger.error(message);
    }
}
