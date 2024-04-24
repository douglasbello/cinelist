package br.com.douglasbello.cinelist.repositories;

import br.com.douglasbello.cinelist.entities.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenresRepository extends JpaRepository<Genres, String> {
}