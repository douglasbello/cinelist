package br.com.douglasbello.cinelist.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shows")
public class Show extends Media {
    @OneToMany(mappedBy = "show")
    private List<Season> seasons = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "shows_languages",
            joinColumns = @JoinColumn(name = "show_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<Language> languages = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "shows_certificates",
            joinColumns = @JoinColumn(name = "show_id"),
            inverseJoinColumns = @JoinColumn(name = "certificate_id")
    )
    private List<Certificate> certificates = new ArrayList<>();
    @ManyToMany
    @JoinTable(
            name = "shows_platforms",
            joinColumns = @JoinColumn(name = "show_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    private List<Platform> platforms = new ArrayList<>();

    public Show() {}

    public List<Season> getSeasons() {
        return seasons;
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
        return "Show{" +
                "seasons=" + seasons +
                ", languages=" + languages +
                ", certificates=" + certificates +
                ", platforms=" + platforms +
                "} " + super.toString();
    }
}