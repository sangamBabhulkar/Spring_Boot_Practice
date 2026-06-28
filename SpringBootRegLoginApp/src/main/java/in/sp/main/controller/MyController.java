package in.sp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.sp.entities.User;
import in.sp.main.services.UserService;

@Controller
public class MyController 
{
	@Autowired
	private UserService userService;
	@GetMapping("/regpage")
	public String openRegPage(Model model)
	{
		model.addAttribute("user",new User());
		return "register";
	}
	
	@PostMapping("/regForm")
	public String submitRegForm(@ModelAttribute("user")User user,Model model)
	{
		boolean status = userService.registerUser(user);
		if(status)
		{
			model.addAttribute("successmsg","user registered successfully");
		}
		else
		{
			model.addAttribute("errormsg","user not registered due to some error");
		}
		return "register";
	}
}
