package br.com.douglasbello.cinelist.repositories;

import br.com.douglasbello.cinelist.entities.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Platform, String> {
}