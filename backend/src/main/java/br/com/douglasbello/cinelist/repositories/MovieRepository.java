package br.com.douglasbello.cinelist.repositories;

import br.com.douglasbello.cinelist.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {
}