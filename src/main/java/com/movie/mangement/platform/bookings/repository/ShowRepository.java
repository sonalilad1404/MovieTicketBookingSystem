package com.movie.mangement.platform.bookings.repository;

import com.movie.mangement.platform.bookings.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
     @Query("SELECT s FROM Show s JOIN s.theatre t JOIN s.movie m " +
            "WHERE m.movieId = :movieId AND t.city = :theatreCity AND s.showDate = :date")
    List<Show> findShowsByMovieCityAndDate(@Param("movieId") Long movieId,
                                           @Param("theatreCity") String theatreCity,
                                           @Param("date") LocalDate date);
}
