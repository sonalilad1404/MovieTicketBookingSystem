package com.movie.mangement.platform.bookings.service;

import com.movie.mangement.platform.bookings.entity.Movie;
import com.movie.mangement.platform.bookings.entity.Show;
import com.movie.mangement.platform.bookings.entity.Theatre;
import com.movie.mangement.platform.bookings.exception.MovieNotFoundException;
import com.movie.mangement.platform.bookings.exception.ShowNotFoundException;
import com.movie.mangement.platform.bookings.exception.TheatreNotFoundException;
import com.movie.mangement.platform.bookings.repository.MovieRepository;
import com.movie.mangement.platform.bookings.repository.ShowRepository;
import com.movie.mangement.platform.bookings.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private MovieRepository movieRepository;

    public List<Show> findShowsByMovieCityAndDate(Long movieId, String city, LocalDate date) {
        return showRepository.findShowsByMovieCityAndDate(movieId,city,date);
    }

    public Show createShow(Long theatreId, Long movieId, Show show) {

        Theatre theatre = theatreRepository.findById(theatreId)
                .orElseThrow(() -> new TheatreNotFoundException(theatreId));

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException(movieId));

        show.setTheatre(theatre);
        show.setMovie(movie);

        return showRepository.save(show);
    }

    public Show updateShow(Long showId, Show showDetails) {
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new ShowNotFoundException(showId));

        show.setShowDate(showDetails.getShowDate());
        show.setShowTime(showDetails.getShowTime());
        show.setPrice(showDetails.getPrice());

        return showRepository.save(show);
    }

    public void deleteShow(Long showId) {
        if (!showRepository.existsById(showId)) {
            throw new ShowNotFoundException(showId);
        }
        showRepository.deleteById(showId);
    }
}
