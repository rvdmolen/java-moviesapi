package com.codingmill.moviesapi.web.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MovieNotCreatedException extends RuntimeException {
    Logger logger = LoggerFactory.getLogger(MovieNotCreatedException.class);

    public MovieNotCreatedException(String message) {
        super(message);
        this.logger.error(message);
    }
}
