package com.moviequote.project.repository;

import com.moviequote.project.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/** MovieRepository extends JpaRepository in order to
 *  inherit several methods for saving, deleting, and finding Movie entities
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // select title from movies where title =
    Movie findByTitle(String title);

    // get all movies that belong to logged-in user
    List<Movie> findByUserId(Long userId);

    //get movie by id and userId
    Movie findByIdAndUserId(Long movieId, Long userId);

    // find movie matches title and userId
    Movie findByUserIdAndTitle(Long userId, String movieTitle);
}
