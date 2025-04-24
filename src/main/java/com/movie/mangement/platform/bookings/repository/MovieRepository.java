package com.movie.mangement.platform.bookings.repository;

import com.movie.mangement.platform.bookings.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Custom queries can be added here
}
