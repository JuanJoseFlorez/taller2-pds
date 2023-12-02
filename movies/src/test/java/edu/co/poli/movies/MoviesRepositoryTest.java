package edu.co.poli.movies;

import edu.co.poli.movies.persistence.entity.Movie;
import edu.co.poli.movies.persistence.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MoviesRepositoryTest {
    @Mock
    private MovieRepository movieRepository;

    @Test
    void findAll(){
        MockitoAnnotations.initMocks(this);
        Movie movie = new Movie();
        movie.setRating(3);
        movie.setTitle("Test movie");
        movie.setDirector("Test movie director");
        movieRepository.save(movie);
        List<Movie> founds =movieRepository.findAll();
        assertNotNull(founds);
    }
}
