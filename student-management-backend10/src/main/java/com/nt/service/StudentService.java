package com.nt.service;

import java.util.List;

import com.nt.entity.Student;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    void deleteStudent(Long id);

    // NEW
    Student updateStudent(
            Long id,
            Student student);
}