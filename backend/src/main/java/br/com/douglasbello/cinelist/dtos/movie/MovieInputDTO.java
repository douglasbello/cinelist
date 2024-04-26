package br.com.douglasbello.cinelist.dtos.movie;

import java.time.LocalDate;
import java.util.List;

public record MovieInputDTO(String title, String shortDescription, String longDescription, String duration, LocalDate releaseDate, String trailerUrl, String thumbnailUrl,
                            List<String> languagesIds, List<String> certificatesIds, List<String> platformsIds, List<String> genresIds) {
}