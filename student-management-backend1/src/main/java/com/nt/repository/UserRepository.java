package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.User;

public interface UserRepository
        extends JpaRepository<User, Long> {

    User findByEmail(
            String email
    );

    User findByNameAndEmail(
            String name,
            String email
    );
}