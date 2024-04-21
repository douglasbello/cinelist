package br.com.douglasbello.cinelist.entities;

import br.com.douglasbello.cinelist.entities.pk.ArtistMoviePK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "artists_movies")
public class ArtistMovie {
    @EmbeddedId
    private ArtistMoviePK id = new ArtistMoviePK();
    private String characterName;
    private String roleDescription;

    public ArtistMovie() {}

    public ArtistMovie(String characterName, String roleDescription) {
        this.characterName = characterName;
        this.roleDescription = roleDescription;
    }
}