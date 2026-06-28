package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Actor;

@RestController
@RequestMapping("/actor-api")
public class ActorController {
	
	@GetMapping("/actor_details")
	public ResponseEntity<Actor> showActorDetails()
	{
		System.out.println("ActorController.showActorDetails");
		Actor a = new Actor(101,"amogh salman","mumbai",123456.0f);
		return new ResponseEntity<Actor>(a,HttpStatus.OK);
	}
}
