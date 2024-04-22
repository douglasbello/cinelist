package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.entities.ActorMovie;
import br.com.douglasbello.cinelist.repositories.ActorMovieRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ActorMovieService implements br.com.douglasbello.cinelist.services.Service<ActorMovie> {
    private final ActorMovieRepository actorMovieRepository;

    public ActorMovieService(ActorMovieRepository actorMovieRepository) {
        this.actorMovieRepository = actorMovieRepository;
    }

    @Override
    public JpaRepository<ActorMovie, String> getRepository() {
        return actorMovieRepository;
    }
}