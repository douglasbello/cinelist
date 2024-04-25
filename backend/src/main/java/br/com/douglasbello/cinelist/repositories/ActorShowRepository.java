package br.com.douglasbello.cinelist.repositories;

import br.com.douglasbello.cinelist.entities.ActorShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorShowRepository extends JpaRepository<ActorShow, String> {
    @Query(nativeQuery = true, value = "SELECT * FROM actors_shows WHERE show_id = :show_id")
    List<ActorShow> findByShowId(@Param("show_id") String show_id);
    @Query(nativeQuery = true, value = "SELECT * FROM actors_shows WHERE actor_id = :actor_id")
    List<ActorShow> findByActorId(@Param("actor_id") String actor_id);
}