package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.entities.Actor;
import br.com.douglasbello.cinelist.entities.ActorShow;
import br.com.douglasbello.cinelist.entities.Movie;
import br.com.douglasbello.cinelist.repositories.MovieRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements br.com.douglasbello.cinelist.services.Service<Movie> {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public JpaRepository<Movie, String> getRepository() {
        return movieRepository;
    }
}