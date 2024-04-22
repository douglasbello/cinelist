package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.entities.Actor;
import br.com.douglasbello.cinelist.repositories.ActorRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ActorService implements br.com.douglasbello.cinelist.services.Service<Actor> {
    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public JpaRepository<Actor, String> getRepository() {
        return actorRepository;
    }
}