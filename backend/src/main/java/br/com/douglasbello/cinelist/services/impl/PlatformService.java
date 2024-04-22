package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.entities.Platform;
import br.com.douglasbello.cinelist.repositories.PlatformRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PlatformService implements br.com.douglasbello.cinelist.services.Service<Platform> {
    private final PlatformRepository platformRepository;

    public PlatformService(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    @Override
    public JpaRepository<Platform, String> getRepository() {
        return platformRepository;
    }
}