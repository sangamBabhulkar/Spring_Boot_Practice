package com.nt.service;

import java.util.List;
import com.nt.entity.Student;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudent(Long id);
}