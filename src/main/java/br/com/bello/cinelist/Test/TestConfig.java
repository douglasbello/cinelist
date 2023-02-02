package br.com.bello.cinelist.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.bello.cinelist.entities.Movie;
import br.com.bello.cinelist.entities.User;
import br.com.bello.cinelist.repositories.MovieRepository;
import br.com.bello.cinelist.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MovieRepository movieRepository;
		
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		
		Movie mov1 = new Movie(null,"Transformers","Descrição do filme",sdf.parse("24/04/2001"),"blabla");
		Movie mov2 = new Movie(null,"Titanic","Descrição do filme",sdf.parse("19/02/1997"),"blabla");

		
		
		movieRepository.saveAll(Arrays.asList(mov1,mov2));
		
		User user1 = new User(null,"douglas@hotmail.com","douglas","douglas123");
		User user2 = new User(null,"rafael@hotmail.com","rafael","rafael123");

		
		userRepository.saveAll(Arrays.asList(user1,user2));
		
		user1.getFavoriteMovies().add(mov1);
		user1.getFavoriteMovies().add(mov2);
		user2.getFavoriteMovies().add(mov2);
		user2.getFavoriteMovies().add(mov1);

		userRepository.saveAll(Arrays.asList(user1,user2));
		
		
	}
}
