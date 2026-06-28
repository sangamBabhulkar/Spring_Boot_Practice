package com.sp.repository;

import java.sql.SQLException;
import java.util.List;

import com.sp.vo.ActorVo;

public interface IActorDao {
	
    // for fetching data
    public List<ActorVo> getAllActorDetails() throws SQLException;

    // ✅ ADD THIS METHOD
    public int insertActor(ActorVo vo) throws SQLException;

	public int registerActorRepo(ActorVo vo);
}