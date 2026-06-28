package com.sp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sp.service.IWishMessageService;

@Controller
public class WishMessageOpearationsController {
	
	@Autowired
	private IWishMessageService service;
//	
//	@RequestMapping("/")
//	public String showHomePage()
//	{
//		System.out.println("WishMessageOperationController.showPage()");
//		//LVN
//		return "welcome";
//	}
//	
//	@RequestMapping("/season")
//	public String showWishMessage(Map<String,Object>map)
//	{
//		//call service class method
//		String msg = service.showWishMessage();
//		//keep the result in shared memory as model attribute
//		map.put("Result", msg);
//		//return LVN
//		return "display";
//	}
	
	@RequestMapping
	public String displayHomePage()
	{
		System.out.println("controller1.displayhoempage()");
		return "home";
	}
	
	
	//@GetMapping("/report")
	//@GetMapping(value="/report",method=RequestMethod.GET)
	/*public String showReport()
	{
		System.out.println("wishmessageoperation.controller");
		return "show_report";
	}*/
	
	@GetMapping("/report")
	@PostMapping("/report")
	//@RequestMapping(value="/report",method=RequestMethod.POST)
	public String showReport2()
	{
		System.out.println("wishmessageoperation1.controller");
		return "show_report1";
	}
	
}
