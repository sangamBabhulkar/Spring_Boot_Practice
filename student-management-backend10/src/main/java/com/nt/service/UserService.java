package com.nt.service;

import com.nt.entity.User;

public interface UserService {

    User registerUser(User user);

    boolean checkEmail(String email);

    // Login Method
    User login(String email, String password);
}