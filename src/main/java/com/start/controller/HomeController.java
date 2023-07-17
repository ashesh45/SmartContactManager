package com.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.start.dao.UserRepository;
import com.start.entites.User;
import com.start.helper.Message;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/")
	public String home(Model model)
	{
		model.addAttribute("title","Home - Smart Contact Manager");
		return "home";
	}
	
	@RequestMapping("/about")
	public String about(Model model)
	{
		model.addAttribute("title","ABOUT - Smart Contact Manager");
		return "about";
	}
	
	@RequestMapping("/login")
	public String login(Model model)
	{
		model.addAttribute("title","ABOUT - Smart Contact Manager");
		return "login";
	}
	
	
	@RequestMapping("/signup")
	public String signup(Model model)
	{
		model.addAttribute("title","Register - Smart Contact Manager");
		model.addAttribute("user",new User());
		return "signup";
	}

	// this handler for registering user
	@PostMapping("/do_register")
	public String registerUser(@ModelAttribute("user") User user,
			@RequestParam(value="agreement",defaultValue = "false") boolean agreement,Model model,
			HttpSession session)
	{
		

			if(!agreement)
			{
				System.out.println("You have not agreed terms and conditions");
			}
			
			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setImageUrl("default.png");
			
			
			
			System.out.println("Agreement "+agreement);
			System.out.println("USER"+user);
			
			User result = this.userRepository.save(user);
			
			model.addAttribute("user", result);
		return "signup";
		
	}
	
}
