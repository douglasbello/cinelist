package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.entities.User;
import br.com.douglasbello.cinelist.repositories.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements br.com.douglasbello.cinelist.services.Service<User> {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public JpaRepository<User, String> getRepository() {
        return userRepository;
    }
}