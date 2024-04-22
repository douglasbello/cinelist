package br.com.douglasbello.cinelist.repositories;

import br.com.douglasbello.cinelist.entities.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, String> {
}