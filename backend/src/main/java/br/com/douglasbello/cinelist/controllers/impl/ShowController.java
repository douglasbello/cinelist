package br.com.douglasbello.cinelist.controllers.impl;

import br.com.douglasbello.cinelist.controllers.Controller;
import br.com.douglasbello.cinelist.dtos.show.ShowInputDTO;
import br.com.douglasbello.cinelist.entities.Season;
import br.com.douglasbello.cinelist.entities.Show;
import br.com.douglasbello.cinelist.services.Service;
import br.com.douglasbello.cinelist.services.impl.ShowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
    public ResponseEntity<Show> insert(@RequestBody ShowInputDTO dto) {
        Show show = showService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(show.getId()).toUri();

        return ResponseEntity.created(uri).body(show);
    }

    @PostMapping("/{showId}/add-season")
    public ResponseEntity<List<Season>> addSeasonToShow(@PathVariable String showId, @RequestBody Season season) {
        return ResponseEntity.ok().body(showService.addSeasonToShow(showId, season));
    }

    @GetMapping("/{showId}/seasons")
    public ResponseEntity<List<Season>> getSeasonsByShowId(@PathVariable String showId) {
        return ResponseEntity.ok().body(showService.getSeasonsOfShow(showId));
    }
}