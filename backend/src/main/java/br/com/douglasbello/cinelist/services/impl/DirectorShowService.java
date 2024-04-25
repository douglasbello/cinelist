package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.entities.Director;
import br.com.douglasbello.cinelist.entities.DirectorMovie;
import br.com.douglasbello.cinelist.entities.DirectorShow;
import br.com.douglasbello.cinelist.entities.Show;
import br.com.douglasbello.cinelist.repositories.DirectorShowRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectorShowService implements br.com.douglasbello.cinelist.services.Service<DirectorShow> {
    private final DirectorShowRepository directorShowRepository;

    public DirectorShowService(DirectorShowRepository directorShowRepository) {
        this.directorShowRepository = directorShowRepository;
    }

    @Override
    public JpaRepository<DirectorShow, String> getRepository() {
        return directorShowRepository;
    }

    public List<Director> addDirectorToShow(DirectorShow directorShow) {
        directorShow = this.save(directorShow);

        return getDirectorsOfShow(directorShow.getShow().getId());
    }

    public List<Director> getDirectorsOfShow(String showId) {
        List<DirectorShow> directorShows = this.directorShowRepository.findByShowId(showId);

        return directorShows.stream().map(x -> {
            return x.getDirector();
        }).collect(Collectors.toList());
    }

    public List<Show> getShowsOfDirector(String directorId) {
        List<DirectorShow> directorShows = this.directorShowRepository.findByDirectorId(directorId);

        return directorShows.stream().map(x ->{
            return x.getShow();
        }).collect(Collectors.toList());
    }
}