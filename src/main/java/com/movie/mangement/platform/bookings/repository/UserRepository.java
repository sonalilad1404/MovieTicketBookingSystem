package com.movie.mangement.platform.bookings.repository;

import com.movie.mangement.platform.bookings.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}