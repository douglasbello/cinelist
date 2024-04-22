package br.com.douglasbello.cinelist.entities;

import br.com.douglasbello.cinelist.entities.pk.ActorMoviePK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "actors_movies")
public class ActorMovie {
    @EmbeddedId
    private ActorMoviePK id = new ActorMoviePK();
    private String characterName;
    private String roleDescription;

    public ActorMovie() {}

    public ActorMovie(String characterName, String roleDescription) {
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
    public Actor getActor() {
        return id.getActor();
    }

    public void setActor(Actor actor) {
        id.setActor(actor);
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public ActorMoviePK getId() {
        return id;
    }

    public void setId(ActorMoviePK id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorMovie that = (ActorMovie) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ActorMovie{" +
                "id=" + id +
                ", characterName='" + characterName + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                '}';
    }
}