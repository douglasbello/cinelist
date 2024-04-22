package br.com.douglasbello.cinelist.entities;

import br.com.douglasbello.cinelist.entities.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends Person {
    private String username;
    private String password;
    private String email;
    @ManyToMany
    @JoinTable(
            name = "user_favorite_movies",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> favoriteMovies = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "user_watch_movies",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> watchMovies = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "user_watch_shows",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "show_id")
    )
    private List<Show> watchShows = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "user_favorite_shows",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "show_id")
    )
    private List<Show> favoriteShows = new ArrayList<>();

    public User() {}

    public User(String firstName, String lastName, LocalDate birthDate, Gender gender, String username, String password, String email) {
        super(firstName, lastName, birthDate, gender);
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(String firstName, String lastName, LocalDate birthDate, Gender gender, String username, String password, String email, String photoUrl) {
        super(firstName, lastName, birthDate, gender, photoUrl);
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Movie> getFavoriteMovies() {
        return favoriteMovies;
    }

    public List<Movie> getWatchMovies() {
        return watchMovies;
    }

    public List<Show> getWatchShows() {
        return watchShows;
    }

    public List<Show> getFavoriteShows() {
        return favoriteShows;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", favoriteMovies=" + favoriteMovies +
                ", watchMovies=" + watchMovies +
                ", watchShows=" + watchShows +
                ", favoriteShows=" + favoriteShows +
                "} " + super.toString();
    }
}