package br.com.douglasbello.cinelist.repositories;

import br.com.douglasbello.cinelist.entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, String> {
}