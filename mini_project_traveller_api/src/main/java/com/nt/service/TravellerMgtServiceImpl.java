package com.nt.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.nt.entity.TravellerEntity;
import com.nt.repository.ITravellerRepo;
import com.nt.vo.TravellerVo;

public class TravellerMgtServiceImpl implements ITravellerMgtService{
	
	@Autowired
	private ITravellerRepo travellerRepo;
	@Override
	public String registerTraveller(TravellerVo vo) {
		//convert vo to entity
		TravellerEntity entity = new TravellerEntity();
		BeanUtils.copyProperties(vo, entity);
		
		//set required data
		entity.setCreatedBy(System.getProperty("user.name"));
		
		int idVal = travellerRepo.saveTraveller(entity);
		return "Traveller is saved with id value :: " + idVal;
		
	}
	//---------------------------------------------------------------------------------
	
	@Override
	public List<TravellerVo> showAllTraveller(){
		List<TravellerEntity>
	}
}
