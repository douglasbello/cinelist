package br.com.douglasbello.cinelist.entities.pk;

import br.com.douglasbello.cinelist.entities.Artist;
import br.com.douglasbello.cinelist.entities.Movie;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ArtistMoviePK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Artist actor;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Artist getActor() {
        return actor;
    }

    public void setActor(Artist actor) {
        this.actor = actor;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
