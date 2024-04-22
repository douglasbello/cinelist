package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.entities.Show;
import br.com.douglasbello.cinelist.repositories.ShowRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ShowService implements br.com.douglasbello.cinelist.services.Service<Show> {
    private final ShowRepository repository;

    public ShowService(ShowRepository repository) {
        this.repository = repository;
    }

    @Override
    public JpaRepository<Show, String> getRepository() {
        return repository;
    }
}