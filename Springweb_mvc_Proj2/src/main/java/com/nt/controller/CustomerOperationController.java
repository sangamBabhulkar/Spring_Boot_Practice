package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerOperationController {
	//handler method will be return LVN
	@RequestMapping("/home")
	public String showHomePage() {
		System.out.println("CustomerOperationController.showControllerMethod");
		//return LVN
		return "welcome";
	}
}
