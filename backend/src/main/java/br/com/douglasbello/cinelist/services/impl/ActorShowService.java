package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.entities.Actor;
import br.com.douglasbello.cinelist.entities.ActorShow;
import br.com.douglasbello.cinelist.entities.Show;
import br.com.douglasbello.cinelist.repositories.ActorShowRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorShowService implements br.com.douglasbello.cinelist.services.Service<ActorShow> {
    private final ActorShowRepository actorShowRepository;
    private final ActorService actorService;
    private final ShowService showService;

    public ActorShowService(ActorShowRepository actorShowRepository, ShowService showService, ActorService actorService) {
        this.actorShowRepository = actorShowRepository;
        this.showService = showService;
        this.actorService = actorService;
    }

    @Override
    public JpaRepository<ActorShow, String> getRepository() {
        return actorShowRepository;
    }

    public List<Actor> addaActorToShow(ActorShow actorShow) {
        actorShow = this.save(actorShow);

        return getActorsOfShow(actorShow.getShow().getId());
    }

    public List<Actor> getActorsOfShow(String showId) {
        List<ActorShow> actorShows = this.actorShowRepository.findByShowId(showId);

        return actorShows.stream().map(x -> {
            return x.getActor();
        }).collect(Collectors.toList());
    }

    public List<Show> getShowsOfActor(String actorId) {
        List<ActorShow> actorShows = this.actorShowRepository.findByActorId(actorId);

        return actorShows.stream().map(x -> {
            return x.getShow();
        }).collect(Collectors.toList());
    }
}