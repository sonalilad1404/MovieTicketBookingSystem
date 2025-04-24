package com.movie.mangement.platform.bookings.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Shows")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showId;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private LocalDate showDate;
    private LocalTime showTime;
    private BigDecimal price;

    private Timestamp createdAt;
    private Timestamp updatedAt;
}
