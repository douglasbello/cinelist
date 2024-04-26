package br.com.douglasbello.cinelist.controllers.impl;

import br.com.douglasbello.cinelist.controllers.Controller;
import br.com.douglasbello.cinelist.entities.Actor;
import br.com.douglasbello.cinelist.entities.ActorMovie;
import br.com.douglasbello.cinelist.entities.Movie;
import br.com.douglasbello.cinelist.services.Service;
import br.com.douglasbello.cinelist.services.impl.ActorMovieService;
import br.com.douglasbello.cinelist.services.impl.ActorService;
import br.com.douglasbello.cinelist.services.impl.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ActorMovieController {
    private final ActorMovieService actorMovieService;
    private final ActorService actorService;
    private final MovieService movieService;

    public ActorMovieController(final ActorMovieService actorMovieService, ActorService actorService, MovieService movieService) {
        this.actorMovieService = actorMovieService;
        this.actorService = actorService;
        this.movieService = movieService;
    }

    @PostMapping("/movies/{movieId}/add-actor/{actorId}")
    public ResponseEntity<List<Actor>> addActorToMovie(@PathVariable String movieId, @PathVariable String actorId, @RequestBody ActorMovie actorMovie) {
        actorMovie.setActor(actorService.findById(actorId));
        actorMovie.setMovie(movieService.findById(movieId));

        return ResponseEntity.ok().body(actorMovieService.addActorToMovie(actorMovie));
    }

    @GetMapping("/movies/{movieId}/actors")
    public ResponseEntity<List<Actor>> getActorsOfMovie(@PathVariable String movieId) {
        return ResponseEntity.ok(actorMovieService.getActorsOfMovie(movieId));
    }

    @GetMapping("/actors/{actorId}/movies")
    public ResponseEntity<List<Movie>> getMoviesOfActor(@PathVariable String actorId) {
        return ResponseEntity.ok(actorMovieService.getMoviesOfActor(actorId));
    }
}