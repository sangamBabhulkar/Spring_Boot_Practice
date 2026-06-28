package com.nt.service;

import java.util.List;

import com.nt.entity.TravellerEntity;
import com.nt.vo.TravellerVo;

public interface ITravellerMgtService {
	public String registerTraveller(TravellerEntity vo);
	
	public List<TravellerVo> showAllTravellers();//display
	public TravellerVo showTravellerById(int id);//show by id
	
	public String updateHeadingToByCurrentLocation(String currentLocation, String newDestination);
	
	public String updateTraveller(TravellerVo vo);
	public String deleteTraveller(int id);
}
