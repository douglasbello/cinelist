package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.entities.User;
import br.com.douglasbello.cinelist.repositories.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements br.com.douglasbello.cinelist.services.Service<User> {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public JpaRepository<User, String> getRepository() {
        return userRepository;
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
}