package com.app.service;

import java.util.List;
import com.app.dao.StudentDAO;
import com.app.model.Student;

public class StudentService {

    StudentDAO dao = new StudentDAO();

    public void save(Student s) {
        dao.save(s);
    }

    public boolean emailExists(String email) {
        return dao.emailExists(email);
    }

    public List<Student> getAll() {
        return dao.getAll();
    }
}