package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Student;
import com.nt.repository.StudentRepository;

@Service
public class StudentServiceImpl
        implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Student saveStudent(
            Student student) {

        return repository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {

        return repository.findAll();
    }

    @Override
    public void deleteStudent(Long id) {

        repository.deleteById(id);
    }

    // UPDATE STUDENT
    @Override
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

            oldStudent.setAddress(
                    student.getAddress());

            oldStudent.setProfilePic(
                    student.getProfilePic());

            return repository.save(
                    oldStudent);
        }

        return null;
    }
}