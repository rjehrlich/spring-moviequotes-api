package com.moviequote.project.service;

import com.moviequote.project.exception.InformationExistException;
import com.moviequote.project.exception.InformationNotFoundException;
import com.moviequote.project.model.Movie;
import com.moviequote.project.model.Quote;
import com.moviequote.project.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * find all movies via the endpoint http://localhost:9893/api/movies/ &
     * @return movies in a list
     */
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovie(@PathVariable Long movieId) {
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isPresent()) {
            return movie;
        } else {
            throw new InformationNotFoundException("movie with the id of " + movieId + " not found");
        }
    }

    public Movie createMovie(@RequestBody Movie movieObject) {
        Movie movie = movieRepository.findByTitle(movieObject.getTitle());
        if (movie != null) {
            throw new InformationExistException("movie with title " + movie.getTitle() + " already exists");
        } else {
            return movieRepository.save(movieObject);
        }
    }

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

    public Optional<Movie> deleteMovie(@PathVariable Long movieId) {
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isPresent()) {
            movieRepository.deleteById(movieId);
            return movie;
        } else {
            throw new InformationNotFoundException("movie with id " + movieId + " not found");
        }
    }

    // Movie Quote services - business logic
        // get called by corresponding controller classes

    public List<Quote> getMovieQuotes(@PathVariable Long movieId) {
        return ;
    }


    public Quote getMovieQuote(@PathVariable Long movieId, @PathVariable Long quoteId) {
        return ;
    }


    public Quote createMovieQuote(@PathVariable Long movieId, @RequestBody Quote quoteObject) {
        return ;
    }


    public Quote updateMovieQuote(@PathVariable Long movieId, @PathVariable Long quoteId, @RequestBody Quote quoteObject) {
        return ;
    }


    public ResponseEntity<HashMap<String, String>> deleteMovieQuote(@PathVariable Long movieId, @PathVariable Long quoteId) {
        return ;
    }
}
