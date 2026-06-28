package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentOperationController {
	@GetMapping("/data")
	public String showData(@RequestParam("sno") int no,@RequestParam("sname")String name)
	{
		System.out.println("Request param values"+no+"----"+name);

		//return LVN 
		return "show_report";
	}
}
