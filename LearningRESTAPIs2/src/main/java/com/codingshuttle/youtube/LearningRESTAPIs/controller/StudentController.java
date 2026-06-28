package com.codingshuttle.youtube.LearningRESTAPIs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.codingshuttle.youtube.LearningRESTAPIs.dto.StudentDto;
import com.codingshuttle.youtube.LearningRESTAPIs.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService = null;
	
	
	@GetMapping("/students")
	public List<StudentDto> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/students/{id}")
	public String getStudentById(@PathVariable long id,@PathVariable String name)
	{
			return studentService.getAllStudentsById();
	}
}
