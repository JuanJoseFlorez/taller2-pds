package edu.co.poli.movies;

import edu.co.poli.movies.persistence.entity.Movie;
import edu.co.poli.movies.persistence.repository.MovieRepository;
import edu.co.poli.movies.service.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class MoviesServiceTest {
    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImpl movieService;

    @Test
    void findByUserId(){
        MockitoAnnotations.initMocks(this);
        Movie movie = new Movie();
        movie.setDirector("Test director");
        movie.setRating(4);
        movie.setTitle("Test title");
        movie.setId(1L);
        when(movieRepository.findById(movie.getId())).thenReturn(Optional.of(movie));
        assertNotNull(movieService.findById(movie.getId()));
    }
}
