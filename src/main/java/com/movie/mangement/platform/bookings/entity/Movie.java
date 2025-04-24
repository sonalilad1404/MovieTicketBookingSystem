package com.movie.mangement.platform.bookings.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String title;
    private String language;
    private String genre;
    private Integer duration;
    private LocalDate releaseDate;

    private Timestamp createdAt;
    private Timestamp updatedAt;
}
