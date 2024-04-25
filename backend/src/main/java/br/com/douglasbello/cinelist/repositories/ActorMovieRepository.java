package br.com.douglasbello.cinelist.repositories;

import br.com.douglasbello.cinelist.entities.ActorMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorMovieRepository extends JpaRepository<ActorMovie, String> {
    @Query(nativeQuery = true, value = "SELECT * FROM actors_movies WHERE movie_id = :movie_id")
    List<ActorMovie> findAllByMovieId(@Param("movie_id") String movieId);
    @Query(nativeQuery = true, value = "SELECT * FROM actors_movies WHERE actor_id = :actor_id")
    List<ActorMovie> findAllByActorId(@Param("actor_id") String actorId);
}