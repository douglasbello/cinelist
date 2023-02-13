package br.com.bello.cinelist.controllers;

import br.com.bello.cinelist.services.UserService;
import br.com.bello.cinelist.utils.Smtp;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import br.com.bello.cinelist.entities.User;

import java.util.Random;

@Controller
public class SignUpController {

	private final UserService userService;

	public SignUpController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/sign-up")
	public ModelAndView url() {
	    ModelAndView mv = new ModelAndView("forms/create");
	    mv.addObject("user", new User());
	    return mv;
	}

	@PostMapping(value = "/sign-up")
	public ModelAndView create(@Valid @ModelAttribute User obj, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		User usernameVerification = userService.findByUsername(obj.getUsername());
		User emailVerification = userService.findByEmail(obj.getEmail());

		if (br.hasErrors()) {
			mv.setViewName("forms/create");
		} else if (usernameVerification != null) {
			mv.addObject("usernameError","Nome de usuário já existente.");
			mv.setViewName("forms/create");
		} else if (emailVerification != null) {
			mv.addObject("emailError","Email já é utilizado.");
			mv.setViewName("forms/create");
		}
		else {
			Random rd = new Random();
			StringBuilder stringBuilder = new StringBuilder();
			for (int i = 0; i < 6; i++) {
				stringBuilder.append(rd.nextInt(10));
			}
			String code = stringBuilder.toString();
			userService.sendEmail(obj.getEmail(),code);
			mv.addObject("emailVerification");
			mv.setViewName("forms/email-verification");

		}
		return mv;
	}
}
