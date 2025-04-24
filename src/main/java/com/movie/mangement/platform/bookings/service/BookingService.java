package com.movie.mangement.platform.bookings.service;

import com.movie.mangement.platform.bookings.entity.*;
import com.movie.mangement.platform.bookings.repository.BookingRepository;
import com.movie.mangement.platform.bookings.repository.ShowRepository;
import com.movie.mangement.platform.bookings.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ShowRepository showRepository;
    private final UserRepository userRepository;

    public Booking bookTickets(Long userId, Long showId, List<Long> seatIds) {
        User user = userRepository.findById(userId).orElseThrow();
        Show show = showRepository.findById(showId).orElseThrow();

        BigDecimal totalAmount = show.getPrice().multiply(BigDecimal.valueOf(seatIds.size()));

        Booking booking = Booking.builder()
                .user(user)
                .show(show)
                .bookingTime(Timestamp.from(Instant.now()))
                .totalAmount(totalAmount)
                .status(BookingStatus.CONFIRMED)
                .createdAt(Timestamp.from(Instant.now()))
                .updatedAt(Timestamp.from(Instant.now()))
                .build();

        return bookingRepository.save(booking);
    }
}

