package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@Controller
public class MyController {

	@Autowired
	private UserService userservice;
	
    @GetMapping("/index")
    public String home() {
        return "index";
    }

	@GetMapping("/regPage")
	public String openRegPage(Model model) {

		model.addAttribute("user", new User());
		return "register";

	}
	

	@PostMapping("/regForm")
	public String submitRegForm(@ModelAttribute("user") User user, Model model) {

		boolean status = userservice.registerUser(user);

		if (status) {

			model.addAttribute("successMsg", "User registered successfully");

		} else {

			model.addAttribute("errorMsg", "user not register due to some error");

		}
		return "register";
	}

	@GetMapping("/loginPage")
	public String openLoginPage(Model model) {
		
		model.addAttribute("user",new User());
		return "login";
		
	}

	@PostMapping("/loginForm")
	public String submitLoginForm(@ModelAttribute("user") User user,Model model){
		
		User validUser = userservice.loginUser(user.getEmail(), user.getPassword());
		
		if(validUser != null) {
		
			return "profile";
			
		}
		
		else {
			model.addAttribute("errorMsg","Emailid and password didnt matched");
		      return "login";
		}
	 }
	
		
}