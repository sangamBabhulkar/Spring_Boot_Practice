package com.codingshuttle.youtube.LearningRESTAPIs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingshuttle.youtube.LearningRESTAPIs.dto.StudentDto;
import com.codingshuttle.youtube.LearningRESTAPIs.entity.Student;
import com.codingshuttle.youtube.LearningRESTAPIs.repository.StudentRepository;
import com.codingshuttle.youtube.LearningRESTAPIs.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
	
	private final StudentRepository studentRepository = null;

	@Override
	public List<StudentDto> getAllStudents() {
	    List<Student> students = studentRepository.findAll();

	    List<StudentDto> studentDtoList = students.stream()
	            .map(student -> new StudentDto(
	                    student.getId(),
	                    student.getName(),
	                    student.getEmail()
	            ))
	            .toList();

	    return studentDtoList;
	}

	@Override
	public StudentDto getAllStudentsById(Long id) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID: "+id);
	}

}
