package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.entities.Season;
import br.com.douglasbello.cinelist.repositories.SeasonRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SeasonService implements br.com.douglasbello.cinelist.services.Service<Season> {
    private final SeasonRepository seasonRepository;

    public SeasonService(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }


    @Override
    public JpaRepository<Season, String> getRepository() {
        return seasonRepository;
    }
}