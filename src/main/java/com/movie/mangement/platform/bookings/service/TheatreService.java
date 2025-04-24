package com.movie.mangement.platform.bookings.service;

import com.movie.mangement.platform.bookings.entity.Theatre;
import com.movie.mangement.platform.bookings.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    public Theatre createTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public Optional<Theatre> getTheatre(Long theatreId) {
        return theatreRepository.findById(theatreId);
    }

}

