package com.sp.service;

import java.sql.SQLException;
import java.util.List;
import com.sp.vo.ActorVo;

public interface IGetActorDetails {
    public List<ActorVo> showActorDetails() throws SQLException;
    public String registerActor(ActorVo vo) throws SQLException;
    public String deleteActorById(int id);
    public ActorVo fetchActorById(int id);
    ActorVo getAcctorById(int id);
    String updateActor(ActorVo vo);
    
}