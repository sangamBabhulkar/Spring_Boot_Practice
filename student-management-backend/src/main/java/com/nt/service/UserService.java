package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.User;
import com.nt.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    // Register User
    public String registerUser(
            User user) {

        User existingUser =
                repository.findByEmail(
                        user.getEmail()
                );

        if (existingUser != null) {

            return
            "Email Already Exists";
        }

        repository.save(user);

        return
        "Registration Successful";
    }

    // Login User
    public String loginUser(
            User user) {

        User validUser =
                repository
                .findByNameAndEmail(
                        user.getName(),
                        user.getEmail()
                );

        if (validUser != null) {

            return
            "Login Successful";
        }

        return
        "Login Failed";
    }
}