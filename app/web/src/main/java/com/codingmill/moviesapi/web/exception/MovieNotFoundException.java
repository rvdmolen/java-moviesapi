package com.codingmill.moviesapi.web.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MovieNotFoundException extends RuntimeException {
    Logger logger = LoggerFactory.getLogger(MovieNotFoundException.class);

    public MovieNotFoundException(String message) {
        super(message);
        this.logger.error(message);
    }
}
