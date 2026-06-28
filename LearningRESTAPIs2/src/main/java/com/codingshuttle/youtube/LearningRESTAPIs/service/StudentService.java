package com.codingshuttle.youtube.LearningRESTAPIs.service;

import java.util.List;

import com.codingshuttle.youtube.LearningRESTAPIs.dto.StudentDto;

public interface StudentService {
	List<StudentDto> getAllStudents();

	StudentDto getAllStudentsById();
}
