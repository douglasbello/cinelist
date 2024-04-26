package br.com.douglasbello.cinelist.controllers.impl;

import br.com.douglasbello.cinelist.entities.Actor;
import br.com.douglasbello.cinelist.entities.Director;
import br.com.douglasbello.cinelist.entities.DirectorMovie;
import br.com.douglasbello.cinelist.entities.Movie;
import br.com.douglasbello.cinelist.services.impl.DirectorMovieService;
import br.com.douglasbello.cinelist.services.impl.DirectorService;
import br.com.douglasbello.cinelist.services.impl.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DirectorMovieController {
    private final DirectorMovieService directorMovieService;
    private final DirectorService directorService;
    private final MovieService movieService;

    public DirectorMovieController(DirectorMovieService directorMovieService, DirectorService directorService, MovieService movieService) {
        this.directorMovieService = directorMovieService;
        this.directorService = directorService;
        this.movieService = movieService;
    }

    @PostMapping("/movies/{movieId}/add-director/{directorId}")
    public ResponseEntity<List<Director>> addDirectorToMovie(@PathVariable String movieId, @PathVariable String directorId, @RequestBody DirectorMovie directorMovie) {
        directorMovie.setDirector(directorService.findById(directorId));
        directorMovie.setMovie(movieService.findById(movieId));

        return ResponseEntity.ok().body(directorMovieService.addDirectorToMovie(directorMovie));
    }

    @GetMapping("/movies/{movieId}/directors")
    public ResponseEntity<List<Director>> getDirectorsOfMovie(@PathVariable String movieId) {
        return ResponseEntity.ok().body(directorMovieService.getDirectorsOfMovie(movieId));
    }

    @GetMapping("/directors/{directorId}/movies")
    public ResponseEntity<List<Movie>> getMoviesOfDirector(@PathVariable String directorId) {
        return ResponseEntity.ok().body(directorMovieService.getMoviesOfDirector(directorId));
    }
}