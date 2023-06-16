package com.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.start.entites.Contact;

@Controller
@RequestMapping("/user")
public class UserController {
	
    @RequestMapping("/index")
	public String dashboard()
	{
		return "user_dashboard";
	}
    
    
 
    //open add form handler
    @GetMapping("/addcontact")
    public String openAddContactForm(Model model)
    {
    	 model.addAttribute("title","Add Contact");
    	 model.addAttribute("contact", new Contact());
    	
    	return "addcontact";
    }
}
