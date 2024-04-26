package br.com.douglasbello.cinelist.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "genres")
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String genre;
    @ManyToMany(mappedBy = "genres")
    private List<Movie> movies = new ArrayList<>();
    @ManyToMany(mappedBy = "genres")
    private List<Show> shows = new ArrayList<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Genres() {}

    public Genres(String genre) {
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @JsonIgnore
    public List<Movie> getMovies() {
        return movies;
    }

    @JsonIgnore
    public List<Show> getShows() {
        return shows;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genres genres = (Genres) o;
        return Objects.equals(id, genres.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Genres{" +
                "id='" + id + '\'' +
                ", genre='" + genre + '\'' +
                ", movies=" + movies +
                ", shows=" + shows +
                '}';
    }
}