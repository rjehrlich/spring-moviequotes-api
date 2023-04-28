package com.moviequote.project.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api") // http://localhost:9893/api
public class MovieController {
    // http://localhost:9893/api/movies/
    @GetMapping(path = "/movies/")
    public String getMovies() {
        return "get all movies";
    }

    // http://localhost:9893/api/movies/1
    @GetMapping(path = "/movies/{movieId}")
    public String getMovie(@PathVariable Long movieId) {
        return "getting the movie with the id of " + movieId;
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
