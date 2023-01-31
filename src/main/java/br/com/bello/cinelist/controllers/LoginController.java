package br.com.bello.cinelist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.bello.cinelist.entities.User;
import br.com.bello.cinelist.repositories.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/sign-in")
	public ModelAndView url() {
		ModelAndView mv = new ModelAndView("forms/login");
		mv.addObject("user",new User());
		return mv;
	}
	
//	@PostMapping("/login")
//	public String login() {
//		
//	}
	
	
}
