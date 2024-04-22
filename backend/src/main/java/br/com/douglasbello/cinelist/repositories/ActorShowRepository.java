package br.com.douglasbello.cinelist.repositories;

import br.com.douglasbello.cinelist.entities.ActorShow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorShowRepository extends JpaRepository<ActorShow, String> {
}