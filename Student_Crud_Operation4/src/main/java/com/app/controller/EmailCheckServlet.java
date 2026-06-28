package com.app.controller;

import java.io.IOException;
import com.app.service.StudentService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/checkEmail")
public class EmailCheckServlet extends HttpServlet {

    StudentService service = new StudentService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String email = req.getParameter("email");

        resp.setContentType("text/plain");

        if (service.emailExists(email)) {
            resp.getWriter().write("❌ Email already exists");
        } else {
            resp.getWriter().write("✅ Email available");
        }
    }
}