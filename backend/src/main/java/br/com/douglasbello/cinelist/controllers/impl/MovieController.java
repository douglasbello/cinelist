package br.com.douglasbello.cinelist.controllers.impl;

import br.com.douglasbello.cinelist.controllers.Controller;
import br.com.douglasbello.cinelist.dtos.movies.MovieInputDTO;
import br.com.douglasbello.cinelist.entities.Actor;
import br.com.douglasbello.cinelist.entities.Language;
import br.com.douglasbello.cinelist.entities.Movie;
import br.com.douglasbello.cinelist.services.Service;
import br.com.douglasbello.cinelist.services.impl.GenresService;
import br.com.douglasbello.cinelist.services.impl.LanguageService;
import br.com.douglasbello.cinelist.services.impl.MovieService;
import br.com.douglasbello.cinelist.services.impl.PlatformService;
import br.com.douglasbello.cinelist.utils.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/movies")
public class MovieController implements Controller<Movie> {
    private final MovieService movieService;
    private final LanguageService languageService;
    private final GenresService genresService;
    private final PlatformService platformService;

    public MovieController(MovieService movieService, LanguageService languageService, GenresService genresService, PlatformService platformService) {
        this.movieService = movieService;
        this.languageService = languageService;
        this.genresService = genresService;
        this.platformService = platformService;
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