package br.com.douglasbello.cinelist.dtos.show;

import java.time.LocalDate;
import java.util.List;

public record ShowInputDTO(String title, String shortDescription, String longDescription, LocalDate releaseDate, String trailerUrl, String thumbnailUrl,
                           List<String> languagesIds, List<String> certificatesIds, List<String> platformsIds, List<String> genresIds) {
}