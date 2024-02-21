package com.codingmill.moviesapi.web.services;

import com.codingmill.moviesapi.database.entities.Movie;
import com.codingmill.moviesapi.database.repositories.MovieRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return StreamSupport.stream(this.movieRepository.findAll().spliterator(), false)
            .toList();
    }

    public Optional<Movie> getMovieById(String movieId) {
        return movieRepository.findById(movieId);
    }

    public Optional<Movie> createMovie(Movie movie) {
        try {
            var newMovie = movieRepository.save(movie);
            if (newMovie.movieId.equals("-1")) {
                return Optional.empty();
            }
            return Optional.of(newMovie);
        } catch (DataIntegrityViolationException e) {
            return Optional.empty();
        }
    }

    public Optional<Boolean> deleteMovie(String movieId) {
        if (movieRepository.existsById(movieId)) {
            movieRepository.deleteById(movieId);
            return Optional.of(true);
        } else {
            return Optional.of(false);
        }
    }

}
