package edu.co.poli.movies.controller;

import edu.co.poli.movies.persistence.entity.Movie;
import edu.co.poli.movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public Movie save(@RequestBody Movie movie) {
        return movieService.save(movie);
    }



    @GetMapping
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable("id") Long id) {
        return movieService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        Movie customer = movieService.findById(id);
        movieService.delete(customer);
    }
}