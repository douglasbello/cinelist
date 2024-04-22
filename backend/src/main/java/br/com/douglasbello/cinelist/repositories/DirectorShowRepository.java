package br.com.douglasbello.cinelist.repositories;

import br.com.douglasbello.cinelist.entities.DirectorShow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorShowRepository extends JpaRepository<DirectorShow, String> {
}