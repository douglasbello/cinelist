package br.com.bello.cinelist.services;

import br.com.bello.cinelist.entities.User;
import br.com.bello.cinelist.repositories.UserRepository;
import br.com.bello.cinelist.repositories.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final EmailService emailService;


    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
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

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User insert(User obj) {
        String encoder = passwordEncoder.encode(obj.getPassword());
        obj.setPassword(encoder);
        return userRepository.save(obj);
    }

    public void saveAll(List<User> list) {
        for (User obj : list) {
            String encoder = passwordEncoder.encode(obj.getPassword());
            obj.setPassword(encoder);
        }
        userRepository.saveAll(list);
    }

    public boolean loginValidation(String username, String password) {
        User obj = new User();
        obj.setUsername(username);
        obj.setPassword(password);
        User bd = findByUsername(username);
        if (bd == null) {
            return false;
        }
        if (!obj.getUsername().equals(bd.getUsername())) {
            return false;
        }
        return passwordEncoder.matches(obj.getPassword(), bd.getPassword());
    }

    public boolean sendEmail(String email, String code) {
        return emailService.sendEmail(email,"Confirmação do endereço de email.","O seu código para confirmação do email é: " + code);
    }
}
