package br.com.douglasbello.cinelist.controllers.impl;

import br.com.douglasbello.cinelist.controllers.Controller;
import br.com.douglasbello.cinelist.entities.Director;
import br.com.douglasbello.cinelist.services.Service;
import br.com.douglasbello.cinelist.services.impl.DirectorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @PostMapping
    public ResponseEntity<Director> insert(@RequestBody Director director) {
        director = directorService.save(director);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(director.getId()).toUri();

        return ResponseEntity.created(uri).body(director);
    }
}