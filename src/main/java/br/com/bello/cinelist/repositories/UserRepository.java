package br.com.bello.cinelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bello.cinelist.entities.User;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
