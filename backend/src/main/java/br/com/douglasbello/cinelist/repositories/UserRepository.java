package br.com.douglasbello.cinelist.repositories;

import br.com.douglasbello.cinelist.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}