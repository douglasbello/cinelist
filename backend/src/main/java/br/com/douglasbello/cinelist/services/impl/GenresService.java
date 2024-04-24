package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.entities.Genres;
import br.com.douglasbello.cinelist.repositories.GenresRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GenresService implements br.com.douglasbello.cinelist.services.Service<Genres> {
    private final GenresRepository genresRepository;

    public GenresService(GenresRepository genresRepository) {
        this.genresRepository = genresRepository;
    }

    @Override
    public JpaRepository<Genres, String> getRepository() {
        return genresRepository;
    }
}