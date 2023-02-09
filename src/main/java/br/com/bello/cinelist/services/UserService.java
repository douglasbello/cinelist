package br.com.bello.cinelist.services;

import br.com.bello.cinelist.entities.User;
import br.com.bello.cinelist.repositories.UserRepository;
import br.com.bello.cinelist.repositories.exceptions.ResourceNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User insert(User obj) {
        String encoder = passwordEncoder.encode(obj.getPassword());
        obj.setPassword(encoder);
        return userRepository.save(obj);
    }

    public boolean loginValidation(String username, String password) {
        User obj = new User();
        obj.setUsername(username);
        obj.setPassword(password);
        User bd = findByUsername(username);
        if (!obj.getUsername().equals(bd.getUsername())) {
            throw new ResourceNotFoundException("Usuário ou senha incorretos.");
        }
        return passwordEncoder.matches(obj.getPassword(), bd.getPassword());
    }
}
