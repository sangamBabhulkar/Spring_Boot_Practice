package com.nt.servlet;



import com.nt.dao.StudentDAO;
import com.nt.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class StudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        // ✅ ADD STUDENT
        if ("add".equals(action)) {

            Student s = new Student();

            s.setName(request.getParameter("name"));
            s.setEmail(request.getParameter("email"));
            s.setCourse(request.getParameter("course"));

            StudentDAO.save(s);

            response.sendRedirect("index.jsp");
        }

        // ✅ DELETE STUDENT
        if ("delete".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));

            StudentDAO.delete(id);

            response.sendRedirect("index.jsp");
        }
    }
}