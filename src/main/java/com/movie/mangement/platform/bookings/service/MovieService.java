package com.movie.mangement.platform.bookings.service;

import com.movie.mangement.platform.bookings.entity.Movie;
import com.movie.mangement.platform.bookings.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Optional<Movie> getMovie(Long movieId) {
        return movieRepository.findById(movieId);
    }

    public List<Movie> listMovies() {
        return movieRepository.findAll();
    }
}

