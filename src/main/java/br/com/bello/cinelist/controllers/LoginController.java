package br.com.bello.cinelist.controllers;

import br.com.bello.cinelist.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.bello.cinelist.entities.User;

@Controller
public class LoginController {

	@Autowired
	private UserService service;

	@GetMapping("/sign-in")
	public ModelAndView url() {
		ModelAndView mv = new ModelAndView("forms/login");
		mv.addObject("user",new User());
		return mv;
	}

	@PostMapping("/sign-in")
	public ModelAndView loginValidation(@Valid @RequestBody User user, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		String password = user.getPassword();
		String username = user.getUsername();
		if (!service.loginValidation(username,password) || br.hasErrors()) {
			mv.setViewName("forms/login");
			mv.addObject(user);
		} else {

		}
		return mv;
	}
}
