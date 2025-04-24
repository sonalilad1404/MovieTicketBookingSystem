package com.movie.mangement.platform.bookings.controller;

import com.movie.mangement.platform.bookings.entity.Movie;
import com.movie.mangement.platform.bookings.entity.Show;
import com.movie.mangement.platform.bookings.service.MovieService;
import com.movie.mangement.platform.bookings.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        // Save movie details in DB
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.addMovie(movie));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        return movieService.getMovie(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Movie>> listMovies() {
        return ResponseEntity.ok(movieService.listMovies());
    }

    @PostMapping("/{movieId}/screenings")
    public ResponseEntity<Show> addScreening(@PathVariable Long movieId, @RequestBody Show show) {
        // Add screening to the movie
        return ResponseEntity.status(HttpStatus.CREATED).body(show);
    }
}

