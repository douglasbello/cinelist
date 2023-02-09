package br.com.bello.cinelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bello.cinelist.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
