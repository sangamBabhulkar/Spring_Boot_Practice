package com.sangam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sangam.db.DBConnection;
import com.sangam.model.Student;

public class StudentDAO {

    private Connection con;

    // Constructor
    public StudentDAO() {
        con = DBConnection.getConnection();
    }

    // INSERT STUDENT
    public boolean addStudent(Student student) {

        boolean status = false;

        try {

            String query =
                "insert into students(firstName,lastName,email) values(?,?,?)";

            PreparedStatement ps =
                con.prepareStatement(query);

            ps.setString(
                1,
                student.getFirstName()
            );

            ps.setString(
                2,
                student.getLastName()
            );

            ps.setString(
                3,
                student.getEmail()
            );

            int row = ps.executeUpdate();

            if (row > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // GET ALL STUDENTS
    public List<Student> getAllStudents() {

        List<Student> list =
            new ArrayList<>();

        try {

            String query =
                "select * from students";

            PreparedStatement ps =
                con.prepareStatement(query);

            ResultSet rs =
                ps.executeQuery();

            while (rs.next()) {

                Student s =
                    new Student();

                s.setId(
                    rs.getInt("id")
                );

                s.setFirstName(
                    rs.getString(
                        "firstName"
                    )
                );

                s.setLastName(
                    rs.getString(
                        "lastName"
                    )
                );

                s.setEmail(
                    rs.getString(
                        "email"
                    )
                );

                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}