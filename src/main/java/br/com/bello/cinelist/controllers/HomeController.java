package br.com.bello.cinelist.controllers;

import br.com.bello.cinelist.entities.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	private final RestTemplate restTemplate;

	public HomeController(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

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

//	@GetMapping(value = "/favorites")
//	public ModelAndView favorites() throws JsonProcessingException {
//		ModelAndView mv = new ModelAndView();
//		String token = "47d272a74c9aad3916ae7e998615a9f1";
//		String url = "https://api.themoviedb.org/3/search/movie?api_key="+token+"&language=en-US&page=1&include_adult=true&query=tropa-de-elite";
//		String data = restTemplate.getForObject(url,String.class);
//
//		ObjectMapper mapper = new ObjectMapper();
//		Movie movie = mapper.readValue(data,Movie.class);
//		mv.setViewName("forms/favorites");
//
//		mv.addObject("movie",movie);
//		return mv;
//	}

//	@GetMapping(value = "/favorites")
//	public ModelAndView favorites() {
//		ModelAndView mv = new ModelAndView();
//		ResponseEntity<Response> response = restTemplate.exchange("https://api.themoviedb.org/3/search/movie?api_key=47d272a74c9aad3916ae7e998615a9f1&language=en-US&page=1&include_adult=true&query=tropa-de-elite", HttpMethod.GET,null,Response.class);
//		Response apiResponse = response.getBody();
//		assert apiResponse != null;
//		List<Movie> movies = apiResponse.getMovies();
//		mv.addObject("results",movies);
//		mv.setViewName("forms/favorites");
//		return mv;
//	}

	@GetMapping(value = "/to-watch")
	public ModelAndView toWatch() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forms/towatch");
		return mv;
	}
}
