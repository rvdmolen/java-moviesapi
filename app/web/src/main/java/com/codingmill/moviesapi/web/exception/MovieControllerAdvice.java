package com.codingmill.moviesapi.web.exception;


import com.codingmill.moviesapi.web.model.MovieError;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieControllerAdvice {

    @ExceptionHandler(MovieNotFoundException.class)
    protected ResponseEntity<MovieError> handleMovieNotFoundException() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new MovieError(404L, "Movie not found"));
    }

    @ExceptionHandler({MovieNotCreatedException.class})
    protected ResponseEntity<MovieError> handleMovieNoCreatedException() {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(new MovieError(400L, "Movie not created due to exception"));
    }
}
