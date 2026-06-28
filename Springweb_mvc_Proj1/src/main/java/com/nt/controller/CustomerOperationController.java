package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerOperationController {
	//handler method which will be return LVN(logical View Name)
	@RequestMapping("/home")
	public String showControllerMethos()
	{
		System.out.println("CustomOperationController.showControllerMethod()");
		//return it will be return logical view  name
		return "welcome";
	}
}
