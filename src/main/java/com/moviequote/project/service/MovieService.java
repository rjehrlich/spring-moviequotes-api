package com.moviequote.project.service;

import com.moviequote.project.exception.InformationExistException;
import com.moviequote.project.exception.InformationNotFoundException;
import com.moviequote.project.model.Movie;
import com.moviequote.project.model.Quote;
import com.moviequote.project.repository.MovieRepository;
import com.moviequote.project.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MovieService {
    private MovieRepository movieRepository;
    private QuoteRepository quoteRepository;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Autowired
    public void setQuoteRepository(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    /**
     * find all movies via the endpoint http://localhost:9893/api/movies/ &
     * @return movies in a list
     */
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovie(Long movieId) {
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isPresent()) {
            return movie;
        } else {
            throw new InformationNotFoundException("movie with the id of " + movieId + " not found");
        }
    }

    public Movie createMovie(Movie movieObject) {
        Movie movie = movieRepository.findByTitle(movieObject.getTitle());
        if (movie != null) {
            throw new InformationExistException("movie with title " + movie.getTitle() + " already exists");
        } else {
            return movieRepository.save(movieObject);
        }
    }

    public Movie updateMovie(Long movieId, Movie movieObject) {
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

    public Optional<Movie> deleteMovie(Long movieId) {
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

    /**
     * Given our movie model has a getQuote list method, we can take the:
     * @param movieId , passed to the getMovie method, and
     * @return all quotes for that given movieId
     */
    public List<Quote> getMovieQuotes(Long movieId) {
        // call the getMovie method for error handling
        return getMovie(movieId).get().getQuoteList();
    }

    /**
     * Takes two variable params representing data being queried
     * @param movieId
     * @param quoteId
     * @return the value of data from db if they exist. Otherwise, throws error for missing info
     */
    public Quote getMovieQuote(Long movieId, Long quoteId) {
        try {
            return getMovieQuotes(movieId).stream().filter(q -> q.getId().equals(quoteId)).findFirst().get();
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("Quote with id " + quoteId + " not found.");
        }
    }

    /**
     * Creates a new movie quote given the two, if they exist:
     * @param movieId
     * @param quoteObject
     * @return them/ saves to the db & associating the two together
     */
    public Quote createMovieQuote(Long movieId, Quote quoteObject) {
        // first check if the movieId exists
        try {
            Optional<Movie> movie = movieRepository.findById(movieId);
            quoteObject.setMovie(movie.get());
            return quoteRepository.save(quoteObject);
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("movie with id " + movieId + " not found.");
        }
    }


    public Quote updateMovieQuote(Long movieId, Long quoteId, Quote quoteObject) {
        return ;
    }


    public ResponseEntity<HashMap<String, String>> deleteMovieQuote(Long movieId, Long quoteId) {
        return ;
    }
}
