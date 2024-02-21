package com.codingmill.moviesapi.web.controller;


import com.codingmill.moviesapi.web.exception.MovieNotCreatedException;
import com.codingmill.moviesapi.web.exception.MovieNotDeletedException;
import com.codingmill.moviesapi.web.exception.MovieNotFoundException;
import com.codingmill.moviesapi.web.mappers.MovieMapper;
import com.codingmill.moviesapi.web.model.MovieCreationDTO;
import com.codingmill.moviesapi.web.model.MovieDTO;
import com.codingmill.moviesapi.web.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MoviesController(MovieService movieService, MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
        this.movieService = movieService;
    }

    @GetMapping(path = "", produces = "application/json")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        var movies = this.movieService.getAllMovies().stream()
            .map(movieMapper::mapToDTO)
            .toList();
        return this.createResponse(movies);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<MovieDTO> getMovie(@PathVariable("id") String movieId) {
        return this.movieService.getMovieById(movieId)
            .map(movieMapper::mapToDTO)
            .map(this::createResponse)
            .orElseThrow(() -> new MovieNotFoundException("Movie not found"));
    }

    @PostMapping(path = "/create", produces = "application/json")
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieCreationDTO movieCreationDTO) {
        var movie = this.movieMapper.movieFromDTO(movieCreationDTO);
        return this.movieService.createMovie(movie)
            .map(movieMapper::mapToDTO)
            .map(this::createResponse)
            .orElseThrow(() -> new MovieNotCreatedException("Failed to create movie"));
    }

    @DeleteMapping(path = "/delete/{id}", produces = "application/json")
    public ResponseEntity<Boolean> deleteMovie(@PathVariable("id") String movieId) {
        return this.movieService.deleteMovie(movieId)
            .filter(result ->result)
            .map(this::createResponse)
            .orElseThrow(() -> new MovieNotDeletedException("Failed to delete movie"));
    }


    private <T> ResponseEntity<T> createResponse(T responseBody) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(responseBody);
    }
}
