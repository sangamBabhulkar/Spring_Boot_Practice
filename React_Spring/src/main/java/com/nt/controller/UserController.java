package com.nt.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nt.config.JwtUtil;
import com.nt.entity.User;
import com.nt.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    UserRepository repo;

    // REGISTER
    @PostMapping("/register")
    public String register(@RequestBody User user) {

        Optional<User> existingUser =
                repo.findByUsername(user.getUsername());

        if (existingUser.isPresent()) {
            return "Username already exists";
        }

        repo.save(user);

        return "Registration Successful";
    }

    // LOGIN WITH JWT
    @PostMapping("/login")
    public Map<String, String> login(
            @RequestBody User user
    ) {

        Optional<User> existingUser =
                repo.findByUsername(user.getUsername());

        if (existingUser.isPresent()) {

            User dbUser = existingUser.get();

            if (dbUser.getPassword()
                    .equals(user.getPassword())) {

                // Generate JWT token
                String token =
                        JwtUtil.generateToken(
                                dbUser.getUsername());

                Map<String, String> res =
                        new HashMap<>();

                res.put("token", token);
                res.put("message",
                        "Login Successful");

                return res;
            }
        }

        throw new RuntimeException(
                "Invalid Credentials");
    }

    // PROFILE API
    @GetMapping("/profile")
    public User profile(
            @RequestHeader("Authorization")
            String authHeader
    ) {

        // remove Bearer
        String token =
                authHeader.replace(
                        "Bearer ", "");

        // get username from token
        String username =
                JwtUtil.extractUsername(token);

        // fetch correct logged in user
        Optional<User> user =
                repo.findByUsername(username);

        if (user.isPresent()) {
            return user.get();
        }

        throw new RuntimeException(
                "User not found");
    }
}