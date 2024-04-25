package br.com.douglasbello.cinelist.repositories;

import br.com.douglasbello.cinelist.entities.DirectorShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DirectorShowRepository extends JpaRepository<DirectorShow, String> {
    @Query(nativeQuery = true, value = "SELECT * FROM directors_shows WHERE show_id = :show_id")
    List<DirectorShow> findByShowId(@Param("show_id") String show_id);
    @Query(nativeQuery = true, value = "SELECT * FROM directors_shows WHERE director_id = :director_id")
    List<DirectorShow> findByDirectorId(@Param("director_id") String director_id);
}