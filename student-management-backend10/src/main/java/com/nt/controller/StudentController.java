package com.nt.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.Student;
import com.nt.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:5176")
public class StudentController {

    @Autowired
    private StudentService service;

    // =========================
    // GET ALL STUDENTS
    // =========================
    @GetMapping
    public List<Student> getStudents() {
        return service.getAllStudents();
    }

    // =========================
    // ADD STUDENT (WITH IMAGE)
    // =========================
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Student addStudent(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("course") String course,
            @RequestParam("address") String address,
            @RequestParam(value = "image", required = false) MultipartFile image
    ) throws IOException {

        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setCourse(course);
        student.setAddress(address);

        // FILE UPLOAD PATH
        String uploadDir = System.getProperty("user.dir") + "/uploads/";

        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        if (image != null && !image.isEmpty()) {

            String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();

            File saveFile = new File(uploadDir + fileName);
            image.transferTo(saveFile);

            student.setProfilePic(fileName);
        }

        return service.saveStudent(student);
    }

    // =========================
    // DELETE STUDENT
    // =========================
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "Deleted Successfully";
    }

    // =========================
    // UPDATE STUDENT
    // =========================
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }
}