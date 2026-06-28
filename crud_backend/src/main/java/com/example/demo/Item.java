package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "items")
@Data // Generates getters, setters, and constructors automatically via Lombok
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}