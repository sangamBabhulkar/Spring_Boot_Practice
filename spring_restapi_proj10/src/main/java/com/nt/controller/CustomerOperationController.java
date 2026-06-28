package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class CustomerOperationController {
	public ResponseEntity<String> showReport(@RequestParam("cno")int no,@RequestParam("cname")String cname){
		System.out.println(no+"..."+cname);
		return new ResponseEntity<String>(no+"..."+cname,HttpStatus.OK);
	}
}
