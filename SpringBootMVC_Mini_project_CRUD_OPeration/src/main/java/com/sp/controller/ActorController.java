package com.sp.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sp.service.IGetActorDetails;
import com.sp.vo.ActorVo;

@Controller
public class ActorController {

    @Autowired
    public IGetActorDetails service;

    // Home page
    @GetMapping("/")
    public String showWelcomePage() {
        return "welcome";
    }

    // Report page
    @GetMapping("/report")
    public String showReport(Map<String, Object> map) throws SQLException {
        List<ActorVo> list = service.showActorDetails();
        map.put("listdetails", list);
        return "show_report";
    }

    // Show form
    @GetMapping("/register")
    public String showAddActorFormPage(@ModelAttribute("actor") ActorVo vo) {
        return "register_actor_form";
    }

    // Save actor
    @PostMapping("/register")
    public String registerActor(Map<String, Object> map,
                                @ModelAttribute("actor") ActorVo vo) throws SQLException {

        String msg = service.registerActor(vo);

        List<ActorVo> listVo = service.showActorDetails();
        map.put("resultMsg", msg);
        map.put("listvo", listVo);

        return "show_report"; // best practice
    }       
        public String removeActorById(@RequestParam("no")int id,Map<String, Object>map)
        {
        	String msg =service.deleteActorById(id);
        	map.put("resultmsg",msg);
        	return "forward:report";
        }
        
        @GetMapping("/edit")
        public String showEditForm(@RequestParam("id") int id,Map<String,Object>map) {
        	ActorVo vo = service.fetchActorById(id);
        	
        	return "edit_actor";
        	
        }
        
        @PostMapping("/update")
        public String updateActor(@ModelAttribute ActorVo vo,Map<String,Object>map)
        {
        	String msg=service.updateActor(vo);
        	map.put("resultmsg", msg);
        	return "redirect:report";
        }
    
}