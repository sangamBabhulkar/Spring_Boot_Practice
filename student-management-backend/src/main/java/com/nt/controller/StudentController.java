package com.nt.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nt.entity.Student;
import com.nt.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin("http://localhost:5173")
public class StudentController {

    @Autowired
    private StudentService service;

    // Add Student
    @PostMapping
    public Student saveStudent(
            @RequestBody Student student) {

        return service.saveStudent(student);
    }

    // Get All Students
    @GetMapping
    public List<Student> getAllStudents() {

        return service.getAllStudents();
    }

    // Get Student By Id
    @GetMapping("/{id}")
    public Student getStudentById(
            @PathVariable Long id) {

        return service.getStudentById(id);
    }

    // Update Student
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        return service.updateStudent(
                id,
                student);
    }

    // Delete Student
    @DeleteMapping("/{id}")
    public String deleteStudent(
            @PathVariable Long id) {

        service.deleteStudent(id);

        return "Student Deleted Successfully";
    }

    // Search Student
    @GetMapping("/search")
    public List<Student> searchStudent(
            @RequestParam String name) {

        return service.searchStudent(name);
    }
}