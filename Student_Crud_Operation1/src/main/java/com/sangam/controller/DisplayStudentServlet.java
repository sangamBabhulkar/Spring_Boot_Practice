package com.sangam.controller;

import java.io.IOException;
import java.util.List;

import com.sangam.dao.StudentDAO;
import com.sangam.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/displayStudents")
public class DisplayStudentServlet
        extends HttpServlet {

    private static final long
        serialVersionUID = 1L;

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException,
            IOException {

        StudentDAO dao =
            new StudentDAO();

        List<Student> list =
            dao.getAllStudents();

        // Send data to JSP
        request.setAttribute(
            "students",
            list
        );

        request.getRequestDispatcher(
            "index.jsp"
        ).forward(
            request,
            response
        );
    }
}