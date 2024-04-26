package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.dtos.movies.MovieInputDTO;
import br.com.douglasbello.cinelist.entities.*;
import br.com.douglasbello.cinelist.repositories.MovieRepository;
import br.com.douglasbello.cinelist.utils.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService implements br.com.douglasbello.cinelist.services.Service<Movie> {
    private final MovieRepository movieRepository;
    private final LanguageService languageService;
    private final GenresService genresService;
    private final PlatformService platformService;
    private final CertificateService certificateService;

    public MovieService(MovieRepository movieRepository, LanguageService languageService, GenresService genresService, PlatformService platformService,
                        CertificateService certificateService) {
        this.movieRepository = movieRepository;
        this.languageService = languageService;
        this.genresService = genresService;
        this.platformService = platformService;
        this.certificateService = certificateService;
    }

    @Override
    public JpaRepository<Movie, String> getRepository() {
        return movieRepository;
    }

    @Deprecated
    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie insert(MovieInputDTO dto) {
        Movie movie = Mapper.movieInputToEntity(dto);
        movie = movieRepository.save(movie);

        List<Language> languages = new ArrayList<>();
        List<Genres> genres = new ArrayList<>();
        List<Certificate> certificates = new ArrayList<>();
        List<Platform> platforms = new ArrayList<>();

        if (dto.languagesIds() != null)
            languages = dto.languagesIds().stream().map(languageService::findById).toList();

        if (dto.genresIds() != null)
            genres = dto.genresIds().stream().map(genresService::findById).toList();

        if (dto.certificatesIds() != null)
            certificates = dto.certificatesIds().stream().map(certificateService::findById).toList();

        if (dto.platformsIds() != null)
            platforms = dto.platformsIds().stream().map(platformService::findById).toList();

        movie.getLanguages().addAll(languages);
        movie.getGenres().addAll(genres);
        movie.getCertificates().addAll(certificates);
        movie.getPlatforms().addAll(platforms);

        return movieRepository.save(movie);
    }
}