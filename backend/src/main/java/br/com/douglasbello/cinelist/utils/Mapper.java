package br.com.douglasbello.cinelist.utils;

import br.com.douglasbello.cinelist.dtos.movies.MovieInputDTO;
import br.com.douglasbello.cinelist.entities.Movie;

public class Mapper {

    public static Movie movieInputToEntity(MovieInputDTO inputDTO) {
        return new Movie(inputDTO.duration(), inputDTO.shortDescription(), inputDTO.title(), inputDTO.longDescription(),
                inputDTO.releaseDate(), inputDTO.thumbnailUrl(), inputDTO.trailerUrl());
    }
}