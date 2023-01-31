package br.com.bello.cinelist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.bello.cinelist.entities.User;
import br.com.bello.cinelist.repositories.UserRepository;
import jakarta.validation.Valid;

@Controller
public class SignUpController {
	
	@Autowired
    private UserRepository repository;
	
	
	@GetMapping("/sign-up")
	public ModelAndView url() {
	    ModelAndView mv = new ModelAndView("forms/create");
	    mv.addObject("user", new User());
	    return mv;
	}

	@PostMapping("/sign-up")
	public String create(@Valid @ModelAttribute User obj) {
		String email = obj.getEmail();
		String username = obj.getUsername();
		String password = obj.getPassword();

		User entity = new User(null, email, username, password);
		repository.save(entity);
		return "redirect:/";
	}
}
