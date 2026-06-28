package com.sp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sp.service.IWishMessageService;

@Controller
public class WishMessageOpearationsController {
	
	@Autowired
	private IWishMessageService service;
	
	@RequestMapping("/")
	public String showHomePage()
	{
		System.out.println("WishMessageOperationController.showPage()");
		//LVN
		return "welcome";
	}
	
	@RequestMapping("/season")
	public String showWishMessage(Map<String,Object>map)
	{
		//call service class method
		String msg = service.showWishMessage();
		//keep the result in shared memory as model attribute
		map.put("Result", msg);
		//return LVN
		return "display";
	}
}
