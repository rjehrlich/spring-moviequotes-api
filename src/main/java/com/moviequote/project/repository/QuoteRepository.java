package com.moviequote.project.repository;

import com.moviequote.project.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
    // get all quotes that belong to the movie
    List<Quote> findByMovieId(Long quoteId);

}
