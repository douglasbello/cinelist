package br.com.douglasbello.cinelist.repositories;

import br.com.douglasbello.cinelist.entities.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, String> {
}