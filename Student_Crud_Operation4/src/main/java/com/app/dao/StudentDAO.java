package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.app.model.Student;

public class StudentDAO {

    String url = "jdbc:mysql://localhost:3306/yourdb";
    String user = "root";
    String pass = "2004";

    // SAVE STUDENT
    public void save(Student s) {

        try {

            System.out.println("Save method started");

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(url, user, pass);

            System.out.println("Database Connected");

            PreparedStatement ps =
                    con.prepareStatement(
                    "INSERT INTO student(name,email,phone,course) VALUES (?,?,?,?)");

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPhone());
            ps.setString(4, s.getCourse());

            int row = ps.executeUpdate();

            System.out.println("Inserted Rows = " + row);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // EMAIL EXISTS CHECK
    public boolean emailExists(String email) {

        boolean exists = false;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(url, user, pass);

            PreparedStatement ps =
                    con.prepareStatement(
                    "SELECT * FROM student WHERE email=?");

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            exists = rs.next();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return exists;
    }

    // GET ALL STUDENTS
    public List<Student> getAll() {

        List<Student> list = new ArrayList<>();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(url, user, pass);

            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM student");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Student s = new Student();

                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setPhone(rs.getString("phone"));
                s.setCourse(rs.getString("course"));

                list.add(s);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}