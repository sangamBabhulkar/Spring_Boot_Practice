package com.fixora.controller;

import com.fixora.model.User;
import com.fixora.dto.UserResponseDTO;
import com.fixora.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            
            // Map Entity -> DTO
            UserResponseDTO responseDTO = new UserResponseDTO(
                registeredUser.getId(),
                registeredUser.getEmail(),
                registeredUser.getFullName(),
                registeredUser.getPhone(),
                registeredUser.getRole()
            );
            
            return ResponseEntity.ok(responseDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> dtos = userService.getAllUsers().stream()
            .map(user -> new UserResponseDTO(
                user.getId(),
                user.getEmail(),
                user.getFullName(),
                user.getPhone(),
                user.getRole()
            ))
            .collect(Collectors.toList());
            
        return ResponseEntity.ok(dtos);
    }
}