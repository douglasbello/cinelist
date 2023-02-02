package br.com.bello.cinelist.controllers;

import br.com.bello.cinelist.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import br.com.bello.cinelist.entities.User;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping(value = "/sign-up")
public class SignUpController {

	@Autowired
    private UserService userService;

	@GetMapping
	public ModelAndView url() {
	    ModelAndView mv = new ModelAndView("forms/create");
	    mv.addObject("user", new User());
	    return mv;
	}

	@PostMapping
	public ModelAndView create(@Valid @ModelAttribute User obj, BindingResult br, RedirectAttributes redirAttrs) {
		ModelAndView mv = new ModelAndView();

		if (br.hasErrors()) {
			mv.setViewName("forms/create");
			mv.addObject("obj");
		} else {
			userService.insert(obj);
			redirAttrs.addAttribute("id", obj.getId()).addFlashAttribute("message", "Account created!");
			mv.setViewName("redirect:/users/{id}");
		}
		return mv;
	}
}
