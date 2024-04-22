package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.entities.Language;
import br.com.douglasbello.cinelist.repositories.LanguageRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class LanguageService implements br.com.douglasbello.cinelist.services.Service<Language> {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public JpaRepository<Language, String> getRepository() {
        return languageRepository;
    }
}