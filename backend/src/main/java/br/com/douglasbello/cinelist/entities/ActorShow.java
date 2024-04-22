package br.com.douglasbello.cinelist.entities;

import br.com.douglasbello.cinelist.entities.pk.ActorShowPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "actors_shows")
public class ActorShow {
    @EmbeddedId
    private ActorShowPK id = new ActorShowPK();
    private String characterName;
    private String roleDescription;

    public ActorShow() {}

    public ActorShow(String characterName, String roleDescription) {
        this.characterName = characterName;
        this.roleDescription = roleDescription;
    }

    public ActorShowPK getId() {
        return id;
    }

    public void setId(ActorShowPK id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorShow actorShow = (ActorShow) o;
        return Objects.equals(id, actorShow.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ActorShow{" +
                "id=" + id +
                ", characterName='" + characterName + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                '}';
    }
}