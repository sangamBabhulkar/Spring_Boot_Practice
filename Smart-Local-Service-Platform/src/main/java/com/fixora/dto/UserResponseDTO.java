package com.fixora.dto;

import com.fixora.model.Role;

public class UserResponseDTO {
    
    private Long id;
    private String email;
    private String fullName;
    private String phone;
    private Role role;

    // Default Constructor
    public UserResponseDTO() {
    }

    // Parameterized Constructor
    public UserResponseDTO(Long id, String email, String fullName, String phone, Role role) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.role = role;
    }

    // GETTERS (Crucial for Jackson JSON conversion)
    public Long getId() { 
        return id; 
    }
    public String getEmail() { 
        return email; 
    }
    public String getFullName() { 
        return fullName; 
    }
    public String getPhone() { 
        return phone; 
    }
    public Role getRole() { 
        return role; 
    }

    // SETTERS
    public void setId(Long id) { 
        this.id = id; 
    }
    public void setEmail(String email) { 
        this.email = email; 
    }
    public void setFullName(String fullName) { 
        this.fullName = fullName; 
    }
    public void setPhone(String phone) { 
        this.phone = phone; 
    }
    public void setRole(Role role) { 
        this.role = role; 
    }
}