package br.com.douglasbello.cinelist.controllers.impl;

import br.com.douglasbello.cinelist.controllers.Controller;
import br.com.douglasbello.cinelist.entities.Language;
import br.com.douglasbello.cinelist.services.Service;
import br.com.douglasbello.cinelist.services.impl.LanguageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguageController implements Controller<Language> {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @Override
    public Service<Language> getService() {
        return languageService;
    }
}