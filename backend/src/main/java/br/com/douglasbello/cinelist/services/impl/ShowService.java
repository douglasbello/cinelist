package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.dtos.show.ShowInputDTO;
import br.com.douglasbello.cinelist.entities.*;
import br.com.douglasbello.cinelist.repositories.ShowRepository;
import br.com.douglasbello.cinelist.utils.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService implements br.com.douglasbello.cinelist.services.Service<Show> {
    private final ShowRepository repository;
    private final LanguageService languageService;
    private final GenresService genresService;
    private final CertificateService certificateService;
    private final PlatformService platformService;
    private final SeasonService seasonService;

    public ShowService(ShowRepository repository, LanguageService languageService, GenresService genresService, CertificateService certificateService,
                       PlatformService platformService, SeasonService seasonService) {
        this.repository = repository;
        this.languageService = languageService;
        this.genresService = genresService;
        this.certificateService = certificateService;
        this.platformService = platformService;
        this.seasonService = seasonService;
    }

    @Override
    public JpaRepository<Show, String> getRepository() {
        return repository;
    }

    @Deprecated
    @Override
    public Show save(Show entity) {
        return repository.save(entity);
    }

    public Show insert(ShowInputDTO dto) {
        Show show = Mapper.showInputToEntity(dto);
        show = repository.save(show);

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

        show.getLanguages().addAll(languages);
        show.getGenres().addAll(genres);
        show.getCertificates().addAll(certificates);
        show.getPlatforms().addAll(platforms);

        return repository.save(show);
    }

    public List<Season> addSeasonToShow(String showId, Season season) {
        Show show = this.findById(showId);
        season = seasonService.save(season);

        show.getSeasons().add(season);
        show = repository.save(show);

        return show.getSeasons();
    }

    public List<Season> getSeasonsOfShow(String showId) {
        Show show = this.findById(showId);

        return show.getSeasons();
    }
}