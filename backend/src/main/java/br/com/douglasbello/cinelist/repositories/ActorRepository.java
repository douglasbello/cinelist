package br.com.douglasbello.cinelist.repositories;

import br.com.douglasbello.cinelist.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, String> {
}