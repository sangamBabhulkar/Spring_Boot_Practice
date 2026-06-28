package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/wishapi")
@RestController
public class WishApiController {
	
	@Value("")
	
	//define endpoints
	@GetMapping("/message")
	public ResponseEntity<String> showWishMessage(){
		//wish message
		String msg = "Good Morning::->"+instance_id;
		//return ResponseEnitity object
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
