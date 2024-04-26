package br.com.douglasbello.cinelist.controllers.impl;

import br.com.douglasbello.cinelist.controllers.Controller;
import br.com.douglasbello.cinelist.dtos.movie.MovieInputDTO;
import br.com.douglasbello.cinelist.entities.Movie;
import br.com.douglasbello.cinelist.services.Service;
import br.com.douglasbello.cinelist.services.impl.GenresService;
import br.com.douglasbello.cinelist.services.impl.LanguageService;
import br.com.douglasbello.cinelist.services.impl.MovieService;
import br.com.douglasbello.cinelist.services.impl.PlatformService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @PostMapping
    public ResponseEntity<Movie> insert(@RequestBody MovieInputDTO dto) {
        Movie movie = movieService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(movie.getId()).toUri();

        return ResponseEntity.created(uri).body(movie);
    }
}