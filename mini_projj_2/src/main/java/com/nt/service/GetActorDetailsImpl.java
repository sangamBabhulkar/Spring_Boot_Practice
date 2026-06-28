package com.nt.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.ActorEntity;
import com.nt.repository.IActorDao;
import com.nt.vo.ActorVo;

@Service
public class GetActorDetailsImpl implements IGetActorSDetails {

	@Autowired
	private IActorDao dao;
	@Override
	public List<ActorVo> showActorDetails() throws SQLException {

	    List<ActorEntity> entityList = dao.getAllActorDetails();
	    List<ActorVo> voList = new ArrayList<>();

	    for (ActorEntity entity : entityList) {

	        ActorVo vo = new ActorVo();

	        vo.setAid(entity.getAid());
	        vo.setAname(entity.getAname());
	        vo.setAddrs(entity.getAddrs());
	        vo.setCat(entity.getCat());
	        vo.setFees(entity.getFees());

	        voList.add(vo);
	    }

	    return voList;
	}
	@Override
	public String registerActor(ActorVo vo) throws SQLException {
	    // convert VO class object to Entity class object
	    //ActorEntity entity = new ActorEntity();
	    //BeanUtils.copyProperties(vo, entity);
	  //  entity.setCreatedBy(System.getProperty("os.name"));
	    // use repo
	    int result = dao.registerActorRepo(vo);
	    if(result > 0)
	        return "Registration succesful";
	    else
	        return "Registration Failed";
	    
	}
	@Override
	public String deleteActor(int id) {

	    int count = dao.deleteActorById(id);

	    if(count == 0) {
	       return "Actor not found with id: " + id;      
	    
	    }

	    return id + " Actor is deleted";
	}
	@Override

	public ActorVo fetchActorById(int id) {

	    ActorEntity entity = dao.getActorById(id);

	    ActorVo vo = null;

	    if (entity != null) {
	        vo = new ActorVo();

	        vo.setAid(entity.getAid());
	        vo.setAname(entity.getAname());
	        vo.setAddrs(entity.getAddrs());
	        vo.setCat(entity.getCat());
	        vo.setFees(entity.getFees());
	    }

	    return vo;
	}
	
	 @Override
	    public String updateActor(ActorVo vo) {

	        int count = dao.updateActor(vo);

	   return count == 1 ? "Actor Updated Successfully" : "Update Failed";
	    }

	

}
