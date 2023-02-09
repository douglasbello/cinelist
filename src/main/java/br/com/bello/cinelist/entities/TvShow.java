package br.com.bello.cinelist.entities;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity(name = "TV_SHOW")
public class TvShow extends Movie {
    private String seasons;

    private String episodes;

    public TvShow(){}

    public TvShow(Long id, String title, String description, Date releaseDate, String imgUrl, String seasons, String episodes) {
        super(id, title, description, releaseDate, imgUrl);
        this.seasons = seasons;
        this.episodes = episodes;
    }

    public String getSeasons() {
        return seasons;
    }

    public void setSeasons(String seasons) {
        this.seasons = seasons;
    }

    public String getEpisodes() {
        return episodes;
    }

    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }
}
