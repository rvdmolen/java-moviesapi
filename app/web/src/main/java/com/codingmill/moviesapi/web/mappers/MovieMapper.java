package com.codingmill.moviesapi.web.mappers;

import com.codingmill.moviesapi.database.entities.Movie;
import com.codingmill.moviesapi.web.model.MovieCreationDTO;
import com.codingmill.moviesapi.web.model.MovieDTO;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieDTO mapToDTO(Movie movie) {
       return new MovieDTO(movie.movieId, movie.name);
    }

    public Movie movieFromDTO(MovieDTO movieDTO) {
        var movie = new Movie();
        movie.name = movieDTO.name();
        movie.movieId = movieDTO.id();
        return movie;
    }

    public Movie movieFromDTO(MovieCreationDTO movieCreationDTO) {
        var movie = new Movie();
        movie.name = movieCreationDTO.name();
        return movie;
    }


}
