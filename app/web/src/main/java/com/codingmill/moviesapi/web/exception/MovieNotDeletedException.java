package com.codingmill.moviesapi.web.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MovieNotDeletedException extends RuntimeException {
    Logger logger = LoggerFactory.getLogger(MovieNotDeletedException.class);

    public MovieNotDeletedException(String message) {
        super(message);
        this.logger.error(message);
    }
}
