package br.com.douglasbello.cinelist.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "movies")
public class Movie extends Media {
    private String duration;

    public Movie() {}

    public Movie(String duration, String shortDescription, String title, String longDescription, Director director, LocalDate releaseDate) {
        super(shortDescription, title, longDescription, director, releaseDate);
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "duration='" + duration + '\'' +
                "} " + super.toString();
    }
}