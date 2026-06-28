package in.sp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>
{
	
}
