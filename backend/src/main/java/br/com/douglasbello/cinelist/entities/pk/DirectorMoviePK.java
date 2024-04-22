package br.com.douglasbello.cinelist.entities.pk;

import br.com.douglasbello.cinelist.entities.Director;
import br.com.douglasbello.cinelist.entities.Movie;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class DirectorMoviePK {
    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}