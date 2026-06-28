package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.beans.MarksInfo;
import com.nt.beans.Student;

@SpringBootApplication
public class ValueAnnotaionSpell1Application {

	public static void main(String[] args) {
	    ApplicationContext ctx=SpringApplication.run(ValueAnnotaionSpell1Application.class, args);
	      //get Spring Bean class obj ref
	          Student stud=ctx.getBean("stud",Student.class);
	          System.out.println(stud);
//	          MarksInfo m1=ctx.getBean("marks",MarksInfo.class);
//	          System.out.println(m1);
	          
	          }

	  }