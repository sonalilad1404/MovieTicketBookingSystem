package com.movie.mangement.platform.bookings.controller;

import com.movie.mangement.platform.bookings.entity.Booking;
import com.movie.mangement.platform.bookings.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> bookTickets(@RequestParam Long userId,
                                               @RequestParam Long showId,
                                               @RequestBody List<Long> seatIds) {
        return ResponseEntity.ok(bookingService.bookTickets(userId, showId, seatIds));
    }
}
