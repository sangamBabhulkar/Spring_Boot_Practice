package com.codingshuttle.youtube.LearningRESTAPIs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingshuttle.youtube.LearningRESTAPIs.dto.StudentDto;

@RestController 
public class StudentController {

    @GetMapping("/student")
    public StudentDto getStudent() {
        return new StudentDto(4L,"sangam","sangam@gmail.com");
    }
    
    @GetMapping("/students")
    public StudentDto getStudentById() {
        return new StudentDto(4L,"san","sangam@gmail.com");
    }
}