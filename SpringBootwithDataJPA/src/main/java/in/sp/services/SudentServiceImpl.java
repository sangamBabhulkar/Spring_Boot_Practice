package in.sp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.entities.Student;
import in.sp.repository.StudentRepository;

@Service
public class SudentServiceImpl implements StudentService
{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public boolean addStudentDetails(Student std) {
		boolean status = false;
		
		try
		{
			studentRepository.save(std);
			status = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = false;
		}
		return false;
	}

}
