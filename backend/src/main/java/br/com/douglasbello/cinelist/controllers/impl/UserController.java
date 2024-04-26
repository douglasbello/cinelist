package br.com.douglasbello.cinelist.controllers.impl;

import br.com.douglasbello.cinelist.controllers.Controller;
import br.com.douglasbello.cinelist.entities.Movie;
import br.com.douglasbello.cinelist.entities.Show;
import br.com.douglasbello.cinelist.entities.User;
import br.com.douglasbello.cinelist.services.Service;
import br.com.douglasbello.cinelist.services.impl.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController implements Controller<User> {
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @Override
    public Service<User> getService() {
        return userService;
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        user = userService.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(user);
    }

    @PostMapping("/favorite-movies/add/{movieId}/{userId}")
    public ResponseEntity<List<Movie>> addFavoriteMovie(@PathVariable final String movieId, @PathVariable final String userId) {
        return ResponseEntity.ok().body(userService.addMovieToFavorites(movieId, userId));
    }

    @GetMapping("/favorite-movies/{userId}")
    public ResponseEntity<List<Movie>> getFavorites(@PathVariable String userId) {
        User user = userService.findById(userId);
        return ResponseEntity.ok().body(user.getFavoriteMovies());
    }

    @PostMapping("/watch-movies/add/{movieId}/{userId}")
    public ResponseEntity<List<Movie>> addWatchMovie(@PathVariable final String movieId, @PathVariable final String userId) {
        return ResponseEntity.ok().body(userService.addMovieToWatch(movieId, userId));
    }

    @GetMapping("/watch-movies/{userId}")
    public ResponseEntity<List<Movie>> getWatchMovie(@PathVariable final String userId) {
        User user = userService.findById(userId);
        return ResponseEntity.ok().body(user.getWatchMovies());
    }

    @PostMapping("/favorite-shows/add/{showId}/{userId}")
    public ResponseEntity<List<Show>> addFavoriteShow(@PathVariable final String showId, @PathVariable final String userId) {
        return ResponseEntity.ok().body(userService.addShowToFavorites(showId, userId));
    }

    @GetMapping("/favorite-shows/{userId}")
    public ResponseEntity<List<Show>> getFavoriteShows(@PathVariable final String userId) {
        User user = userService.findById(userId);
        return ResponseEntity.ok().body(user.getFavoriteShows());
    }

    @PostMapping("/watch-shows/add/{showId}/{userId}")
    public ResponseEntity<List<Show>> addWatchShow(@PathVariable final String showId, @PathVariable final String userId) {
        return ResponseEntity.ok().body(userService.addShowToWatch(showId, userId));
    }

    @GetMapping("/watch-shows/{userId}")
    public ResponseEntity<List<Show>> getWatchShows(@PathVariable final String userId) {
        User user = userService.findById(userId);
        return ResponseEntity.ok().body(user.getWatchShows());
    }
}