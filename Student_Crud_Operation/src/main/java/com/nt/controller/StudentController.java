package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nt.entity.Student;
import com.nt.service.StudentService;

@RestController
@RequestMapping("/api/students")
//@CrossOrigin("http://localhost:5173")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student saveStudent(
            @RequestBody Student student) {
        return service.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(
            @PathVariable Long id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        Student existing =
                service.getStudentById(id);

        existing.setFirstName(
                student.getFirstName());

        existing.setLastName(
                student.getLastName());

        existing.setEmail(
                student.getEmail());

        return service.updateStudent(existing);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(
            @PathVariable Long id) {

        service.deleteStudent(id);

        return "Student Deleted";
    }
}