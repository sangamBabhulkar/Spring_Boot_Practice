package com.fixora.repository;

import com.fixora.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query method to find a user by email (crucial for later login implementation)
    Optional<User> findByEmail(String email);
}