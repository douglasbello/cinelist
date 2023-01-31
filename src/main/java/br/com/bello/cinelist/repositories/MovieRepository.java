package br.com.bello.cinelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bello.cinelist.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long> {

}
