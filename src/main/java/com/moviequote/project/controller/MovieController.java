package com.moviequote.project.controller;

import com.moviequote.project.model.Movie;
import com.moviequote.project.model.Quote;
import com.moviequote.project.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    // http://localhost:9893/api/movies/1/quotes
    @GetMapping(path = "/movies/{movieId}/quotes")
    public List<Quote> getMovieQuotes(@PathVariable Long movieId) {
        return ;
    }

    // http://localhost:9893/api/movies/1/quotes/1
    @GetMapping(path = "/movies/{movieId}/quotes/{quoteId}")
    public Quote getMovieQuote(@PathVariable Long movieId, @PathVariable Long quoteId) {
        return ;
    }

    // http://localhost:9893/api/movies/1/quotes
    @PostMapping(path = "/movies/{movieId}/quotes")
    public Quote createMovieQuote(@PathVariable Long movieId, @RequestBody Quote quoteObject) {
        return ;
    }

    // http://localhost:9893/api/movies/1/quotes/1
    @PutMapping(path = "/movies/{movieId}/quotes/{quoteId}")
    public Quote updateMovieQuote(@PathVariable Long movieId, @PathVariable Long quoteId, @RequestBody Quote quoteObject) {
        return ;
    }

    // http://localhost:9893/api/movies/1/quotes/1
    @DeleteMapping(path = "/movies/{movieId}/quotes/{quoteId}")
    public ResponseEntity<HashMap<String, String>> deleteMovieQuote(@PathVariable Long movieId, @PathVariable Long quoteId) {
        return ;
    }
}
