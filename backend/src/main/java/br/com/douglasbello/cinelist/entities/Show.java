package br.com.douglasbello.cinelist.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shows")
public class Show extends Media {
    @OneToMany(mappedBy = "show")
    private List<Season> seasons = new ArrayList<>();

    public Show() {}

    public List<Season> getSeasons() {
        return seasons;
    }

    @Override
    public String toString() {
        return "Show{" +
                "seasons=" + seasons +
                "} " + super.toString();
    }
}