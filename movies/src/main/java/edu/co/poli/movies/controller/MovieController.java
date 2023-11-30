package edu.co.poli.movies.controller;

import edu.co.poli.movies.helper.Response;
import edu.co.poli.movies.helper.ResponseBuild;
import edu.co.poli.movies.persistence.entity.Movie;
import edu.co.poli.movies.service.MovieService;
import edu.co.poli.movies.service.dto.MovieInDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final ResponseBuild builder;

    @PostMapping
    public Response save(@Valid @RequestBody MovieInDTO movie, BindingResult result) {
        if(result.hasErrors()){
            return builder.failed(this.formatMessage(result));
        }
        movieService.save(movie);
        return builder.success(movie);
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
    public Response delete(@PathVariable("id") Long id) {
        Movie movie = movieService.findById(id);
        if(movie==null){
            return builder.failed("Not found");
        }

        String message = movieService.delete(movie);
        if(message == "Eliminado correctamente"){
            return builder.success(message);
        }
        return builder.failed(message);

    }

    private List<Map<String, String>> formatMessage(BindingResult result) {
        return result.getFieldErrors().stream()
                .map(error -> {
                    Map<String, String> err = new HashMap<>();
                    err.put(error.getField(), error.getDefaultMessage());
                    return err;
                }).collect(Collectors.toList());
    }
}