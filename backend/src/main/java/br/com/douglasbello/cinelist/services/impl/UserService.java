package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.entities.Movie;
import br.com.douglasbello.cinelist.entities.Show;
import br.com.douglasbello.cinelist.entities.User;
import br.com.douglasbello.cinelist.repositories.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements br.com.douglasbello.cinelist.services.Service<User> {
    private final UserRepository userRepository;
    private final MovieService movieService;
    private final ShowService showService;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository, MovieService movieService, ShowService showService) {
        this.userRepository = userRepository;
        this.movieService = movieService;
        this.showService = showService;
    }

    @Override
    public JpaRepository<User, String> getRepository() {
        return userRepository;
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public List<Movie> addMovieToFavorites(String movieId, String userId) {
        Movie movie = movieService.findById(movieId);
        User user = this.findById(userId);
        user.getFavoriteMovies().add(movie);
        this.save(user);

        return user.getFavoriteMovies();
    }

    public List<Movie> addMovieToWatch(String movieId, String userId) {
        Movie movie = movieService.findById(movieId);
        User user = this.findById(userId);
        user.getWatchMovies().add(movie);
        this.save(user);

        return user.getWatchMovies();
    }

    public List<Show> addShowToWatch(String movieId, String userId) {
        Show show = showService.findById(movieId);
        User user = this.findById(userId);
        user.getWatchShows().add(show);
        this.save(user);

        return user.getWatchShows();
    }

    public List<Show> addShowToFavorites(String showId, String userId) {
        Show show = showService.findById(showId);
        User user = this.findById(userId);
        user.getFavoriteShows().add(show);
        this.save(user);

        return user.getFavoriteShows();
    }
}