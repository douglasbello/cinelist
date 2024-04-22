package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.entities.DirectorMovie;
import br.com.douglasbello.cinelist.repositories.DirectorMovieRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DirectorMovieService implements br.com.douglasbello.cinelist.services.Service<DirectorMovie> {
    private final DirectorMovieRepository directorRepository;

    public DirectorMovieService(DirectorMovieRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public JpaRepository<DirectorMovie, String> getRepository() {
        return directorRepository;
    }
}