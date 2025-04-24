package com.movie.mangement.platform.bookings.repository;

import com.movie.mangement.platform.bookings.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
