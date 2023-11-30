package edu.co.poli.movies.service;

import edu.co.poli.movies.persistence.entity.Movie;
import edu.co.poli.movies.service.dto.MovieInDTO;

import java.util.List;

public interface MovieService {

    Movie save(MovieInDTO movie);
    String delete(Movie movie);
    List<Movie> findAll();
    Movie findById(Long id);
}
