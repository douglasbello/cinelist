package br.com.douglasbello.cinelist.entities.pk;

import br.com.douglasbello.cinelist.entities.Director;
import br.com.douglasbello.cinelist.entities.Show;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class DirectorShowPK {
    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }
}