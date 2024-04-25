package br.com.douglasbello.cinelist.repositories;

import br.com.douglasbello.cinelist.entities.DirectorMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DirectorMovieRepository extends JpaRepository<DirectorMovie, String> {
    @Query(nativeQuery = true, value = "SELECT * FROM directors_movies WHERE movie_id = :movie_id")
    List<DirectorMovie> findByMovieId(@Param("movie_id") String movie_id);
    @Query(nativeQuery = true, value = "SELECT * FROM directors_movies WHERE director_id = :director_id")
    List<DirectorMovie> findByDirectorId(@Param("director_id") String director_id);
}