package com.movie.mangement.platform.bookings.controller;

import com.movie.mangement.platform.bookings.entity.Show;
import com.movie.mangement.platform.bookings.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping("/{movieId}/theatres")
    public List<Show> getShows(
            @PathVariable Long movieId,
            @RequestParam String city,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        if (date == null) {
            date = LocalDate.now();
        }
        return showService.findShowsByMovieCityAndDate(movieId, city, date);
    }

    @PostMapping("/theatreId/{theatreId}/movie/{movieId}")
    public ResponseEntity<Show> createShow(@PathVariable Long theatreId,
                                           @PathVariable Long movieId,
                                           @RequestBody Show show) {
        return ResponseEntity.ok(showService.createShow(theatreId, movieId, show));
    }

    @PutMapping("/{showId}")
    public ResponseEntity<Show> updateShow(@PathVariable Long showId,
                                           @RequestBody Show show) {
        return ResponseEntity.ok(showService.updateShow(showId, show));
    }

    @DeleteMapping("/{showId}")
    public ResponseEntity<Void> deleteShow(@PathVariable Long showId) {
        showService.deleteShow(showId);
        return ResponseEntity.noContent().build();
    }
}
