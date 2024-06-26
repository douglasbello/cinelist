package br.com.douglasbello.cinelist.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shows")
public class Show extends Media {
    @OneToMany(mappedBy = "show")
    private List<Season> seasons = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "shows_languages",
            joinColumns = @JoinColumn(name = "show_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<Language> languages = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "shows_certificates",
            joinColumns = @JoinColumn(name = "show_id"),
            inverseJoinColumns = @JoinColumn(name = "certificate_id")
    )
    private List<Certificate> certificates = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "shows_platforms",
            joinColumns = @JoinColumn(name = "show_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    private List<Platform> platforms = new ArrayList<>();
    @ManyToMany(mappedBy = "watchShows")
    private List<User> watchShowsUsers = new ArrayList<>();
    @ManyToMany(mappedBy = "favoriteShows")
    private List<User> favoriteShowsUsers = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "shows_genres",
            joinColumns = @JoinColumn(name = "show_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genres> genres = new ArrayList<>();

    public Show() {}

    public Show(String shortDescription, String title, String trailerUrl, String thumbnailUrl, String longDescription, LocalDate releaseDate) {
        super(shortDescription, title, trailerUrl, thumbnailUrl, longDescription, releaseDate);
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    @JsonIgnore
    public List<User> getWatchShowsUsers() {
        return watchShowsUsers;
    }

    @JsonIgnore
    public List<User> getFavoriteShowsUsers() {
        return favoriteShowsUsers;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return "Show{" +
                "seasons=" + seasons +
                ", languages=" + languages +
                ", certificates=" + certificates +
                ", platforms=" + platforms +
                ", watchShowsUsers=" + watchShowsUsers +
                ", favoriteShowsUsers=" + favoriteShowsUsers +
                ", genres=" + genres +
                "} " + super.toString();
    }
}