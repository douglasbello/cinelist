package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.entities.Director;
import br.com.douglasbello.cinelist.repositories.DirectorRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DirectorService implements br.com.douglasbello.cinelist.services.Service<Director> {
    private final DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public JpaRepository<Director, String> getRepository() {
        return directorRepository;
    }
}