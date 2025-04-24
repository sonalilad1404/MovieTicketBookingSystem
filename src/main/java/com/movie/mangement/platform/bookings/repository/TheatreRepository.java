package com.movie.mangement.platform.bookings.repository;

import com.movie.mangement.platform.bookings.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    // Custom queries can be added here, if necessary
}
