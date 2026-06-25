package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nt.entity.User;
import com.nt.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:5173")
public class UserController {

    @Autowired
    private UserService service;

    // Register API
    @PostMapping("/register")
    public String registerUser(
            @RequestBody User user) {

        return service
                .registerUser(user);
    }

    // Login API
    @PostMapping("/login")
    public String loginUser(
            @RequestBody User user) {

        return service
                .loginUser(user);
    }
}