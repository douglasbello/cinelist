package br.com.douglasbello.cinelist.controllers.impl;

import br.com.douglasbello.cinelist.controllers.Controller;
import br.com.douglasbello.cinelist.entities.Show;
import br.com.douglasbello.cinelist.services.Service;
import br.com.douglasbello.cinelist.services.impl.ShowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/shows")
public class ShowController implements Controller<Show> {
    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @Override
    public Service<Show> getService() {
        return showService;
    }

    @PostMapping
    public ResponseEntity<Show> insenrt(@RequestBody Show show) {
        show = showService.save(show);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(show.getId()).toUri();

        return ResponseEntity.created(uri).body(show);
    }
}