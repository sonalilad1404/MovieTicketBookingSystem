package com.movie.mangement.platform.bookings.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotNull(message = "Name cannot be null")  // Ensure name is not null
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")  // Ensure name length
    private String name;

    @NotNull(message = "Email cannot be null")  // Ensure email is not null
    @Email(message = "Invalid email format")  // Ensure email is in a valid format
    private String email;

    @NotNull(message = "Password cannot be null")  // Ensure password is not null
    @Size(min = 6, max = 255, message = "Password must be between 6 and 255 characters")  // Ensure password length
    private String password;

    @NotNull(message = "Created at time cannot be null")  // Ensure createdAt is not null
    private Timestamp createdAt;

    @NotNull(message = "Updated at time cannot be null")  // Ensure updatedAt is not null
    private Timestamp updatedAt;
}