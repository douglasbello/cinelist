package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.entities.Actor;
import br.com.douglasbello.cinelist.entities.Director;
import br.com.douglasbello.cinelist.entities.DirectorMovie;
import br.com.douglasbello.cinelist.entities.Movie;
import br.com.douglasbello.cinelist.repositories.DirectorMovieRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectorMovieService implements br.com.douglasbello.cinelist.services.Service<DirectorMovie> {
    private final DirectorMovieRepository directorRepository;

    public DirectorMovieService(DirectorMovieRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public JpaRepository<DirectorMovie, String> getRepository() {
        return directorRepository;
    }

    public List<Director> addDirectorToMovie(DirectorMovie directorMovie) {
        directorMovie = this.save(directorMovie);

        return getDirectorsOfMovie(directorMovie.getMovie().getId());
    }

    public List<Director> getDirectorsOfMovie(String movieId) {
        List<DirectorMovie> directorMovies = this.directorRepository.findByMovieId(movieId);

        return directorMovies.stream().map(x -> {
            return x.getDirector();
        }).collect(Collectors.toList());
    }

    public List<Movie> getMoviesOfDirector(String directorId) {
        List<DirectorMovie> directorMovies = this.directorRepository.findByDirectorId(directorId);

        return directorMovies.stream().map(x -> {
            return x.getMovie();
        }).collect(Collectors.toList());
    }
}