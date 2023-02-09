package br.com.bello.cinelist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CineListApplication {
	public static void main(String[] args) {
		SpringApplication.run(CineListApplication.class, args);
	}
}