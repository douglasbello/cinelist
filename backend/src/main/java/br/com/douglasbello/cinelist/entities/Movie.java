package br.com.douglasbello.cinelist.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie extends Media {
    private String duration;
    @ManyToMany
    @JoinTable(
            name = "movies_languages",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<Language> languages = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "movies_certificates",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "certificate_id")
    )
    private List<Certificate> certificates = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "movies_platforms",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    private List<Platform> platforms = new ArrayList<>();

    public Movie() {}

    public Movie(String duration, String shortDescription, String title, String longDescription, LocalDate releaseDate, String thumbnailUrl, String trailerUrl) {
        super(shortDescription, title, trailerUrl, thumbnailUrl, longDescription, releaseDate);
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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

    @Override
    public String toString() {
        return "Movie{" +
                "duration='" + duration + '\'' +
                ", languages=" + languages +
                ", certificates=" + certificates +
                ", platforms=" + platforms +
                "} " + super.toString();
    }
}