package com.sp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.repository.IActorDao;
import com.sp.vo.ActorVo;

@Service
public class GetActorDetailsImpl implements IGetActorDetails {

    @Autowired
    private IActorDao dao;

    @Override
    public List<ActorVo> showActorDetails() throws SQLException {
        return dao.getAllActorDetails(); // ✅ fixed
    }

    @Override
    public String registerActor(ActorVo vo) throws SQLException {
        int result = dao.registerActorRepo(vo);
        if(result > 0)
        	return "registration successful";
        else
        	return "registration fail";
    }

	@Override
	public String deleteActorById(int id) {
		int  count = 0;
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","2004");
		return null;
	}
}