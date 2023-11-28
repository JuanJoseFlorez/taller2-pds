package edu.co.poli.movies.service;

import edu.co.poli.movies.persistence.entity.Movie;
import edu.co.poli.movies.persistence.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;


    @Override
    public Movie save(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    @Override
    public void delete(Movie movie) {
        movieRepository.delete(movie);

    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
}


