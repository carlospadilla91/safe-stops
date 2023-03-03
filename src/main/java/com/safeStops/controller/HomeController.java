package com.safeStops.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.safeStops.model.User;

@Controller
public class HomeController {
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage() {
		return "register";
	}
	
	@RequestMapping(value = "/safeStops", method = RequestMethod.GET)
	public String listSafeStops() {
		return "/safeStops/index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, @ModelAttribute("user") User user) {
		if(user != null && user.getUsername() != null && user.getPassword() != null) {
			if(user.getUsername().equals("carlos") && user.getPassword().equals("password1234")) {
				return "redirect:/safeStops/";
			} else {
				model.addAttribute("error", "Incorrect Username or Password");
				return "/login";
			}
		} else {
			model.addAttribute("error", "Incorrect Username or Password");
			return "/login";
		}
		
	}
	
}


