package br.com.bello.cinelist.controllers;

import br.com.bello.cinelist.entities.Movie;
import br.com.bello.cinelist.entities.Response;
import br.com.bello.cinelist.services.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FavoriteController {

    public final MovieService movieService;


    public FavoriteController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value = "/favorites")
    public ModelAndView listFavorites() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forms/favorites");
        List<Movie> movies = movieService.SearchByMovieName();
        mv.addObject("movie",movies);

        return mv;
    }
}
