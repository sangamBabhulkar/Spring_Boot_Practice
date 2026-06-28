package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing-api")
public class BillingControllerService {
	
	@GetMapping("/info")
	public String getBillingInfo()
	{
		return "we accept card payment ," + 
	"upi payment, net banking payment cod";
		}
}
