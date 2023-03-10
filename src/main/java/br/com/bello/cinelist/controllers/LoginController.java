package br.com.bello.cinelist.controllers;

import br.com.bello.cinelist.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.bello.cinelist.entities.User;

@Controller
public class LoginController {

	private final UserService service;

	public LoginController(UserService service) {
		this.service = service;
	}

	@GetMapping("/sign-in")
	public ModelAndView url() {
		ModelAndView mv = new ModelAndView("forms/login");
		mv.addObject("user",new User());
		return mv;
	}

	@PostMapping("/sign-in")
	public ModelAndView loginValidation(@Valid User user, BindingResult br, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (br.hasErrors()) {
			mv.setViewName("forms/login");
		}
		else if (!service.loginValidation(user.getUsername(),user.getPassword())) {
			mv.addObject("error","Usuário ou senha não encontrados.");
			mv.setViewName("forms/login");
		} else {
			session.setAttribute("loggedUser",user);
			mv.setViewName("redirect:/home");
		}
		return mv;
	}
}
