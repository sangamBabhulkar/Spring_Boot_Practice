package in.sp.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sp.model.Student;

@Controller
public class StudentOperationController {
	
	//handler method for home page
	@GetMapping("/")
	public String showHomePage()
	{
		System.out.println("StudentOperationController.showHomePage");
		//return LVN
		return "welcome";
	}
	
	//handler method for display student registration form
	@GetMapping("/register")
	public String showStudentRegistrationForm()
	{
		System.out.println("StudentOperationController.showStudentRegistrationForm()");
		return "student_register";
	}
	
	//handler method for displaying form and performance of student
	@PostMapping("/register")
	public String registerStudent(@ModelAttribute("stud")Student st,Map<String,Object>map)
	{
		System.out.println("StudentOperationController.registerStudent()");
		//get the performance of the student
		String result=null;
		if(st.getSavg()<=35)
			result= "fail";
		else if(st.getSavg()<50)
			result= "Third class";
		else if(st.getSavg()<60)
			result= "second";
		else if(st.getSavg()<75)
			result= "first class";
		else
			result= "first class with distinction";
		
		//store result in shared object as a model attribute
		map.put("resultMsg", result);
		//return LVN
		return "display";
			
	}
}
