package br.com.bello.cinelist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home/index";
	}
	
	
//	@GetMapping("/create")
//	public String create() {
//		return "create";
//	}
	
}
