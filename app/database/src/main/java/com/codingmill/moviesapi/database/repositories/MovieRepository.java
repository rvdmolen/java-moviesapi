package com.codingmill.moviesapi.database.repositories;

import com.codingmill.moviesapi.database.entities.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, String> {

    List<Movie> findByName(String name);
}
