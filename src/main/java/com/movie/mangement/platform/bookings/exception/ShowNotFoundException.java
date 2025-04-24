package com.movie.mangement.platform.bookings.exception;

public class ShowNotFoundException extends RuntimeException {

    public ShowNotFoundException(Long showId) {
        super("Show not found with id: " + showId);
    }
}
