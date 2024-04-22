package br.com.douglasbello.cinelist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CinelistApplication {
    public static void main(String[] args) {
        SpringApplication.run(CinelistApplication.class, args);
    }
}