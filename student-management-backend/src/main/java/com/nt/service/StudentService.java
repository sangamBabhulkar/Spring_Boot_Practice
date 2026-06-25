package com.nt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Student;
import com.nt.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // Add Student
    public Student saveStudent(
            Student student) {

        return repository.save(student);
    }

    // Get All Students
    public List<Student> getAllStudents() {

        return repository.findAll();
    }

    // Get Student By Id
    public Student getStudentById(
            Long id) {

        return repository.findById(id)
                .orElse(null);
    }

    // Update Student
    public Student updateStudent(
            Long id,
            Student student) {

        Student oldStudent =
                repository.findById(id)
                .orElse(null);

        if (oldStudent != null) {

            oldStudent.setName(
                    student.getName());

            oldStudent.setEmail(
                    student.getEmail());

            oldStudent.setCourse(
                    student.getCourse());

            oldStudent.setCity(
                    student.getCity());

            return repository.save(
                    oldStudent);
        }

        return null;
    }

    // Delete Student
    public void deleteStudent(
            Long id) {

        repository.deleteById(id);
    }

    // Search Student
    public List<Student> searchStudent(
            String name) {

        return repository
                .findByNameContaining(name);
    }
}