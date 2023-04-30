package com.moviequote.project.controller;

import com.moviequote.project.exception.InformationExistException;
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

    /**
     * find all movies via the endpoint http://localhost:9893/api/movies/ &
     * @return them in a list
     */
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
    public Movie createMovie(@RequestBody Movie movieObject) {
       Movie movie = movieRepository.findByTitle(movieObject.getTitle());
       if (movie != null) {
           throw new InformationExistException("movie with title " + movie.getTitle() + " already exists");
       } else {
           return movieRepository.save(movieObject);
       }
    }

    // http://localhost:9893/api/movies/1
    @PutMapping(path = "/movies/{movieId}")
    public Movie updateMovie(@PathVariable Long movieId, @RequestBody Movie movieObject) {
        Optional<Movie> movie = getMovie(movieId);
        if (movieObject.getTitle().equals(movie.get().getTitle())) {
            throw new InformationExistException("Movie " + movie.get().getTitle() + " already exists");
        } else {
            Movie updateMovie = movieRepository.findById(movieId).get();
            updateMovie.setTitle(movieObject.getTitle());
            updateMovie.setGenre(movieObject.getGenre());
            return movieRepository.save(updateMovie);
        }
    }

    // http://localhost:9893/api/movies/1
    @DeleteMapping(path = "/movies/{movieId}")
    public Optional<Movie> deleteMovie(@PathVariable Long movieId) {
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isPresent()) {
            movieRepository.deleteById(movieId);
            return movie;
        } else {
            throw new InformationNotFoundException("movie with id " + movieId + " not found");
        }
    }

}
