package com.moviequote.project.controller;

import com.moviequote.project.exception.InformationNotFoundException;
import com.moviequote.project.model.Movie;
import com.moviequote.project.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api") // http://localhost:9893/api
public class MovieController {

    private MovieRepository movieRepository;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // http://localhost:9893/api/movies/
    @GetMapping(path = "/movies/")
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    // http://localhost:9893/api/movies/1
    @GetMapping(path = "/movies/{movieId}")
    public Optional<Movie> getMovie(@PathVariable Long movieId) {
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isPresent()) {
            return movie;
        } else {
            throw new InformationNotFoundException("movie with the id of " + movieId + " not found");
        }
    }

    // http://localhost:9893/api/movies/
    @PostMapping(path = "/movies/")
    public String createMovie(@RequestBody String body) {
        return "Creating a movie " + body;
    }

    // http://localhost:9893/api/movies/1
    @PutMapping(path = "/movies/{movieId}")
    public String updateMovie(@PathVariable Long movieId, @RequestBody String body) {
        return "updating the movie with the id of " + movieId + " with this info " + body;
    }

    // http://localhost:9893/api/movies/1
    @DeleteMapping(path = "/movies/{movieId}")
    public String deleteMovie(@PathVariable String movieId) {
        return "deleting the movie that has the id of " + movieId;
    }
}
