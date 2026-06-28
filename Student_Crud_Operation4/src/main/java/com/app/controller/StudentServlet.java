package com.app.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.app.model.Student;
import com.app.service.StudentService;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    StudentService service = new StudentService();

    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        Student s = new Student();

        s.setName(req.getParameter("name"));
        s.setEmail(req.getParameter("email"));
        s.setPhone(req.getParameter("phone"));
        s.setCourse(req.getParameter("course"));

        service.save(s);

        System.out.println("Student Saved");

        resp.sendRedirect(req.getContextPath()
                + "/student?action=list");
    }

    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("list".equals(action)) {

            List<Student> list =
                    service.getAll();

            req.setAttribute("students", list);

            RequestDispatcher rd =
                    req.getRequestDispatcher("/list.jsp");

            rd.forward(req, resp);
        }
    }
}