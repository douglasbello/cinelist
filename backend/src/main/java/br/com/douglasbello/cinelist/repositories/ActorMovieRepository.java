package br.com.douglasbello.cinelist.repositories;

import br.com.douglasbello.cinelist.entities.ActorMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorMovieRepository extends JpaRepository<ActorMovie, String> {
}