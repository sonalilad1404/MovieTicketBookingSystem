package com.movie.mangement.platform.bookings.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "Theatres")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theatreId;

    private String name;
    private String city;
    private String address;
    private String email;
    private String phone;

    private Timestamp createdAt;
    private Timestamp updatedAt;
}
