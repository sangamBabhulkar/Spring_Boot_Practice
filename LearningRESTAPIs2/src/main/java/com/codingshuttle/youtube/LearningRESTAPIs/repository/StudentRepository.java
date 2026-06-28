package com.codingshuttle.youtube.LearningRESTAPIs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingshuttle.youtube.LearningRESTAPIs.entity.Student;


public interface StudentRepository extends JpaRepository<Student,Long>{

}
