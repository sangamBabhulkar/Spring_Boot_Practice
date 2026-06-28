package com.nt.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.service.IGetActorSDetails;
import com.nt.vo.ActorVo;

@Controller
public class ActorController {

	@Autowired
	private IGetActorSDetails service;
	
	//handler method  for displaying home page
	@GetMapping("/")
	public String showWelcomePage()
	{
		return "welcome";
	}
	//handler for registration
	@GetMapping("/report")
	public String showReport(Map<String,Object> map) throws SQLException
	{
		List<ActorVo> list=service.showActorDetails();
		map.put("listVo", list);
		return "show_report";
		
		
	}
	
	
@GetMapping("/register")
public String showAddActorFormPage(@ModelAttribute("actor") ActorVo vo) {
	    System.out.println("ActorOperationsController.showAddActorFormPage()");
	    return "register_actor_form";
	}
	
	
	
	@PostMapping("/register")
	public String registerActor(Map<String, Object> map, 
	       @ModelAttribute("actor") ActorVo vo) throws SQLException {
	    System.out.println("ActorOperationsController.registerActor()");
	    // use service
	    String msg = service.registerActor(vo);
	    List<ActorVo> listVO = service.showActorDetails();
	    // keep the results in model attributes
	    map.put("resultMsg", msg);
	    map.put("listVo", listVO);
	    // return LVN
	    return "show_report";
	}
	

@GetMapping("/remove")
public String removeActorById(@RequestParam("no") int id,
                             Map<String, Object> map) {

    String msg = service.deleteActor(id);

    map.put("resultMsg", msg);

    return "forward:report";
}
@GetMapping("/edit")
public String showEditForm(@RequestParam("id") int id, Map<String, Object> map) {

    ActorVo vo = service.fetchActorById(id);
    map.put("actor", vo);

    return "edit_actor";   // edit_actor.jsp
}

@PostMapping("/update")
public String updateActor(@ModelAttribute ActorVo vo, Map<String, Object> map) {

    String msg = service.updateActor(vo);
    map.put("resultMsg", msg);
    System.out.println("message is "+msg);
    return "redirect:report";
}


}
