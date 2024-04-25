package br.com.douglasbello.cinelist.controllers.impl;

import br.com.douglasbello.cinelist.controllers.Controller;
import br.com.douglasbello.cinelist.entities.Actor;
import br.com.douglasbello.cinelist.entities.Movie;
import br.com.douglasbello.cinelist.services.Service;
import br.com.douglasbello.cinelist.services.impl.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController implements Controller<Movie> {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public Service<Movie> getService() {
        return movieService;
    }
}