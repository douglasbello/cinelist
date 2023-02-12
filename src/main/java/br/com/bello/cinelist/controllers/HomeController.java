package br.com.bello.cinelist.controllers;

import br.com.bello.cinelist.entities.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	/*
	Na função 'index', quando um usuário acessa o endpoint, é verificado se ele está logado, através da HttpSession, se ele estiver logado
	ele é direcionado para a página 'logged-home', caso o contrário, ele é direcionado a página 'unlogged-home'.
	 */
	@GetMapping(value = "/home")
	public ModelAndView index(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("loggedUser");
		if (user == null) {
			mv.setViewName("home/unlogged-home");
		} else {
			mv.setViewName("home/logged-home");
		}
		return mv;
	}

	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/sign-in";
	}

	@GetMapping(value = "/favorites")
	public ModelAndView favorites() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forms/favorites");
		return mv;
	}

	@GetMapping(value = "/to-watch")
	public ModelAndView toWatch() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forms/towatch");
		return mv;
	}
}
