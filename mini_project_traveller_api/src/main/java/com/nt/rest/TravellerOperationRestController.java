package com.nt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.service.ITravellerMgtService;
import com.nt.vo.TravellerVo;

@RestController
@RequestMapping("/traveller-api")
public class TravellerOperationRestController {
	
	@Autowired
	private ITravellerMgtService travellerService;
	
	@PostMapping("/save")
	public ResponseEntity<String> registerTraveller(@RequestBody TravellerVo vo){
		try {
			//use service
			String msg = travellerService.registerTraveller(vo);
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new
					ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//========================================================================
	//2nd end point for retriving all records
	@GetMapping("/findAll")
	public ResponseEnity<?> displayAllTravellers(){
		try {
			
		}
	}
}

//==================================================
@PathMapping("/update/{currentLocation}/{headingTo}")
public ResponseEntity<String> updateHeadingToByCurrentLocation(@PathVariable String currentLocation,@PathVariable String headingTo){
	//use serive
	String msg = travellerService.updateHeadingToByCurrentLocation(currentLocation, headingTo);
	return new ResponseEntity<String>(msg,HttpStatus.OK);
}
