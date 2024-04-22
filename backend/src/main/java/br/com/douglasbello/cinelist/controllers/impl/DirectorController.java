package br.com.douglasbello.cinelist.controllers.impl;

import br.com.douglasbello.cinelist.controllers.Controller;
import br.com.douglasbello.cinelist.entities.Director;
import br.com.douglasbello.cinelist.services.Service;
import br.com.douglasbello.cinelist.services.impl.DirectorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/directors")
public class DirectorController implements Controller<Director> {
    private final DirectorService directorService;

    public DirectorController(final DirectorService directorService) {
        this.directorService = directorService;
    }

    @Override
    public Service<Director> getService() {
        return directorService;
    }
}