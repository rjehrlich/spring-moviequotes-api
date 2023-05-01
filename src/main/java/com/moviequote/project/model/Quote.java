package com.moviequote.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "quotes")
public class Quote {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String quote_text;

    // many quotes belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    // many quotes can belong to one movie
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Quote() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuote_text() {
        return quote_text;
    }

    public void setQuote_text(String quote_text) {
        this.quote_text = quote_text;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", quote_text='" + quote_text + '\'' +
                '}';
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /********** user getters and setters **********/

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
