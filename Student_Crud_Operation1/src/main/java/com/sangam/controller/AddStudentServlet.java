package com.sangam.controller;

import java.io.IOException;

import com.sangam.dao.StudentDAO;
import com.sangam.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        // Get data from form
        String firstName =
            request.getParameter(
                "firstName"
            );

        String lastName =
            request.getParameter(
                "lastName"
            );

        String email =
            request.getParameter(
                "email"
            );

        // Set data into model
        Student student =
            new Student();

        student.setFirstName(
            firstName
        );

        student.setLastName(
            lastName
        );

        student.setEmail(
            email
        );

        // Save into DB
        StudentDAO dao =
            new StudentDAO();

        dao.addStudent(student);

        // Redirect
        response.sendRedirect(
            "displayStudents"
        );
    }
}