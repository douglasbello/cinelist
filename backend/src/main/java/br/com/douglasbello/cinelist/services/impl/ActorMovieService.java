package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.entities.Actor;
import br.com.douglasbello.cinelist.entities.ActorMovie;
import br.com.douglasbello.cinelist.entities.Movie;
import br.com.douglasbello.cinelist.repositories.ActorMovieRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorMovieService implements br.com.douglasbello.cinelist.services.Service<ActorMovie> {
    private final ActorMovieRepository actorMovieRepository;
    private final ActorService actorService;
    private final MovieService movieService;

    public ActorMovieService(ActorMovieRepository actorMovieRepository, ActorService actorService, MovieService movieService) {
        this.actorMovieRepository = actorMovieRepository;
        this.actorService = actorService;
        this.movieService = movieService;
    }

    @Override
    public JpaRepository<ActorMovie, String> getRepository() {
        return actorMovieRepository;
    }

    public List<Actor> addActorToMovie(ActorMovie actorMovie) {
        actorMovie = this.save(actorMovie);
        return getActorsOfMovie(actorMovie.getId().getMovie().getId());
    }

    public List<Actor> getActorsOfMovie(String movieId) {
        List<ActorMovie> actorMovies = actorMovieRepository.findAllByMovieId(movieId);

        return actorMovies.stream().map(x -> {
            return x.getActor();
        }).collect(Collectors.toList());
    }

    public List<Movie> getMoviesOfActor(String actorId) {
        List<ActorMovie> actorMovies = actorMovieRepository.findAllByActorId(actorId);

        return actorMovies.stream().map(x -> {
            return x.getMovie();
        }).collect(Collectors.toList());
    }
}