package com.moviequote.project.repository;

import com.moviequote.project.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** MovieRepository extends JpaRepository in order to
 *  inherit several methods for saving, deleting, and finding Movie entities
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // select title from movies where title =
    Movie findByTitle(String title);
}
