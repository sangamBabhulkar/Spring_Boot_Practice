package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Student;

public interface StudentRepository
        extends JpaRepository<Student, Long> {

    List<Student> findByNameContaining(
            String name
    );
}