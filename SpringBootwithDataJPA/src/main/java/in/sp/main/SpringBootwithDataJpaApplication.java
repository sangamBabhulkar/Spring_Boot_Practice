package in.sp.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.sp.entities.Student;
import in.sp.services.StudentService;
import in.sp.services.SudentServiceImpl;

@SpringBootApplication
public class SpringBootwithDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootwithDataJpaApplication.class, args);
		
		StudentService stdService = context.getBean(SudentServiceImpl.class);
		
		Student std = new Student();
		std.setName("Sangam");
		std.setRollno(101);
		std.setMarks(99.0f);
		
		boolean status = stdService.addStudentDetails(std);
		if(status)
		{
			System.out.println("student inserted successfully");
		}
		else
		{
			System.out.println("student not inserted successfully");
		}
	}

}
