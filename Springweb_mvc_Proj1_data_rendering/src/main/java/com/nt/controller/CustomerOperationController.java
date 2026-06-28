package com.nt.controller;

import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerOperationController {
	//handler method will be return LVN
//	@RequestMapping("/")
//	public String showHomePage(BindingAwareModelMap map) {
//		System.out.println("CustomerOperationController.showControllerMethod");
//		//add data to the shared memory as model attribute
//		map.addAttribute("sysDate", new Date());
//		map.addAttribute("age",new Random().nextInt(40));
//		return "welcome";
//	}
	
	/*@RequestMapping("/process")
	public String processs()
	{
		System.out.println("showHomeController.process()");
		return "forward:report";
	}
	
	@RequestMapping("/report")
	public String showReport()
	{
		System.out.println("CustomerOperationController.showReport()");
		return "show_report";
	}*/
	
	@RequestMapping("/")
	public String showHomePage(Map<String,Object>map)
	{
		System.out.println("customerOperationController.showHomePage()::shared class");
		map.put("sysDate",new Date());
		map.put("age", new Random().nextInt(40));
		return "forward:report";
	}
	
	@RequestMapping("/report")
	public String showHomePage()
	{
		System.out.println("customerOperationController.showReport()");
		
		return "show_report";
	}
}
