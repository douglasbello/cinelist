package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.entities.DirectorShow;
import br.com.douglasbello.cinelist.repositories.DirectorShowRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DirectorShowService implements br.com.douglasbello.cinelist.services.Service<DirectorShow> {
    private final DirectorShowRepository directorShowRepository;

    public DirectorShowService(DirectorShowRepository directorShowRepository) {
        this.directorShowRepository = directorShowRepository;
    }

    @Override
    public JpaRepository<DirectorShow, String> getRepository() {
        return directorShowRepository;
    }
}