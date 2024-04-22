package br.com.douglasbello.cinelist.repositories;

import br.com.douglasbello.cinelist.entities.DirectorMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorMovieRepository extends JpaRepository<DirectorMovie, String> {
}