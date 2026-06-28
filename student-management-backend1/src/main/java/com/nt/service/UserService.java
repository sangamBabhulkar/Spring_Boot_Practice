package com.nt.service;

import com.nt.entity.User;
import com.nt.repository.UserRepository;
import com.nt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    // REGISTER
    public String registerUser(User user) {

        if (repository.findByEmail(user.getEmail()) != null) {
            return "Email Already Exists";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);

        return "Registration Successful";
    }

    // LOGIN
    public String loginUser(User user) {

        User dbUser = repository.findByEmail(user.getEmail());

        if (dbUser != null &&
                passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {

            return jwtUtil.generateToken(dbUser.getEmail());
        }

        return "INVALID_CREDENTIALS";
    }
}