package br.com.douglasbello.cinelist.utils;

import br.com.douglasbello.cinelist.dtos.movie.MovieInputDTO;
import br.com.douglasbello.cinelist.dtos.show.ShowInputDTO;
import br.com.douglasbello.cinelist.entities.Movie;
import br.com.douglasbello.cinelist.entities.Show;

public class Mapper {

    public static Movie movieInputToEntity(MovieInputDTO inputDTO) {
        return new Movie(inputDTO.duration(), inputDTO.shortDescription(), inputDTO.title(), inputDTO.longDescription(),
                inputDTO.releaseDate(), inputDTO.thumbnailUrl(), inputDTO.trailerUrl());
    }

    public static Show showInputToEntity(ShowInputDTO inputDTO) {
        return new Show(inputDTO.shortDescription(), inputDTO.title(), inputDTO.trailerUrl(), inputDTO.thumbnailUrl(), inputDTO.longDescription(), inputDTO.releaseDate());
    }
}