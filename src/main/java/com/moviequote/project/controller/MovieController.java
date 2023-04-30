package com.moviequote.project.controller;

import com.moviequote.project.model.Movie;
import com.moviequote.project.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api") // http://localhost:9893/api
public class MovieController {

    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    // call the getMovies method inside movieService
    @GetMapping(path = "/movies/")
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    // http://localhost:9893/api/movies/1
    @GetMapping(path = "/movies/{movieId}")
    public Optional<Movie> getMovie(@PathVariable Long movieId) {
        return movieService.getMovie(movieId);
    }

    // http://localhost:9893/api/movies/
    @PostMapping(path = "/movies/")
    public Movie createMovie(@RequestBody Movie movieObject) {
       return movieService.createMovie(movieObject);
    }

    // http://localhost:9893/api/movies/1
    @PutMapping(path = "/movies/{movieId}")
    public Movie updateMovie(@PathVariable Long movieId, @RequestBody Movie movieObject) {
        return movieService.updateMovie(movieId, movieObject);
    }

    // http://localhost:9893/api/movies/1
    @DeleteMapping(path = "/movies/{movieId}")
    public Optional<Movie> deleteMovie(@PathVariable Long movieId) {
        return movieService.deleteMovie(movieId);
    }

}
