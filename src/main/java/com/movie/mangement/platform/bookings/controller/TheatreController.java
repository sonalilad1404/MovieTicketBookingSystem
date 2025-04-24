package com.movie.mangement.platform.bookings.controller;

import com.movie.mangement.platform.bookings.entity.Theatre;
import com.movie.mangement.platform.bookings.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/theatres")
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping
    public ResponseEntity<Theatre> createTheatre(@RequestBody Theatre theatre) {
        Theatre createdTheatre = theatreService.createTheatre(theatre);
        return ResponseEntity.status(HttpStatus.CREATED).body(theatre);
    }

    @GetMapping("/{theatreId}")
    public ResponseEntity<Theatre> getTheatre(@PathVariable Long theatreId) {
        Optional<Theatre> theatre = theatreService.getTheatre(theatreId);
        return theatre.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

