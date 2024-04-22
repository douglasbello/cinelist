package br.com.douglasbello.cinelist.entities;

import br.com.douglasbello.cinelist.entities.pk.DirectorMoviePK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "directors_movies")
public class DirectorMovie {
    @EmbeddedId
    private DirectorMoviePK id;
    private String characterName;
    private String roleDescription;

    public DirectorMovie() {}

    public DirectorMovie(String characterName, String roleDescription) {
        this.characterName = characterName;
        this.roleDescription = roleDescription;
    }

    @JsonIgnore
    public Movie getMovie() {
        return id.getMovie();
    }

    public void setMovie(Movie movie) {
        id.setMovie(movie);
    }

    @JsonIgnore
    public Director getDirector() {
        return id.getDirector();
    }

    public void setDirector(Director director) {
        id.setDirector(director);
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectorMovie that = (DirectorMovie) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "DirectorMovie{" +
                "id=" + id +
                ", characterName='" + characterName + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                '}';
    }
}