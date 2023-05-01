package com.moviequote.project.service;

import com.moviequote.project.exception.InformationExistException;
import com.moviequote.project.exception.InformationNotFoundException;
import com.moviequote.project.model.Movie;
import com.moviequote.project.model.Quote;
import com.moviequote.project.model.User;
import com.moviequote.project.repository.MovieRepository;
import com.moviequote.project.repository.QuoteRepository;
import com.moviequote.project.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MovieService {
    private MovieRepository movieRepository;
    private QuoteRepository quoteRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository, QuoteRepository quoteRepository) {
        this.movieRepository = movieRepository;
        this.quoteRepository = quoteRepository;
    }

    public static User getCurrentLoggedInUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        return userDetails.getUser();
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
        Optional<Movie> movie = getMovie(movieId);
        Quote quote = quoteRepository.findByMovieId(movieId).stream()
                .filter((q -> q.getMovie().equals(quoteObject.getMovie()))).findFirst().get();
        if (quote != null) {
            throw new InformationExistException("Quote with that movie already exists.");
        } else {
            quoteObject.setMovie(movie.get());
            return quoteRepository.save(quoteObject);
        }
    }

    /**
     * Update a movie quote with the following params/ data
     * @param movieId
     * @param quoteId
     * @param quoteObject
     * @return the data saved into the db using the quote repository save method if all data exists
     */
    public Quote updateMovieQuote(Long movieId, Long quoteId, Quote quoteObject) {
        Quote quote = getMovieQuote(movieId, quoteId);
        quote.setMovie((quoteObject.getMovie()));
        quote.setQuote_text(quoteObject.getQuote_text());
        return quoteRepository.save(quote);
    }


    public Quote deleteMovieQuote(Long movieId, Long quoteId) {
       Quote quote = getMovieQuote(movieId, quoteId);
       quoteRepository.delete(quote);
       return quote;
    }
}
