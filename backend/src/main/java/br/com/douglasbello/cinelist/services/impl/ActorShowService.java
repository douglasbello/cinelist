package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.entities.ActorShow;
import br.com.douglasbello.cinelist.repositories.ActorShowRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ActorShowService implements br.com.douglasbello.cinelist.services.Service<ActorShow> {
    private final ActorShowRepository actorShowRepository;

    public ActorShowService(ActorShowRepository actorShowRepository) {
        this.actorShowRepository = actorShowRepository;
    }

    @Override
    public JpaRepository<ActorShow, String> getRepository() {
        return actorShowRepository;
    }
}