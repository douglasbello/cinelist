package br.com.douglasbello.cinelist.entities;

import br.com.douglasbello.cinelist.entities.pk.DirectorShowPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "directors_shows")
public class DirectorShow {
    @EmbeddedId
    private DirectorShowPK id = new DirectorShowPK();

    public DirectorShow() {}

    @JsonIgnore
    public Director getDirector() {
        return id.getDirector();
    }

    public void setDirector(Director director) {
        id.setDirector(director);
    }

    @JsonIgnore
    public Show getShow() {
        return id.getShow();
    }

    public void setShow(Show show) {
        id.setShow(show);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirectorShow that = (DirectorShow) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "DirectorShow{" +
                "id=" + id +
                '}';
    }
}