package br.com.douglasbello.cinelist.controllers.impl;

import br.com.douglasbello.cinelist.entities.Director;
import br.com.douglasbello.cinelist.entities.DirectorShow;
import br.com.douglasbello.cinelist.entities.Show;
import br.com.douglasbello.cinelist.services.impl.DirectorService;
import br.com.douglasbello.cinelist.services.impl.DirectorShowService;
import br.com.douglasbello.cinelist.services.impl.ShowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DirectorShowController {
    private final DirectorShowService directorShowService;
    private final DirectorService directorService;
    private final ShowService showService;

    public DirectorShowController(DirectorShowService directorShowService, DirectorService directorService, ShowService showService) {
        this.directorShowService = directorShowService;
        this.directorService = directorService;
        this.showService = showService;
    }

    @PostMapping("/shows/{showId}/add-director/{directorId}")
    public ResponseEntity<List<Director>> addDirectorToShow(@PathVariable String showId, @PathVariable String directorId, @RequestBody DirectorShow directorShow) {
        directorShow.setDirector(directorService.findById(directorId));
        directorShow.setShow(showService.findById(showId));

        return ResponseEntity.ok(directorShowService.addDirectorToShow(directorShow));
    }

    @GetMapping("/shows/{showId}/actors")
    public ResponseEntity<List<Director>> getDirectorsOfShow(@PathVariable String showId) {
        return ResponseEntity.ok().body(directorShowService.getDirectorsOfShow(showId));
    }

    @GetMapping("/directors/{directorId}/shows")
    public ResponseEntity<List<Show>> getShowsOfDirector(@PathVariable String directorId) {
        return ResponseEntity.ok().body(directorShowService.getShowsOfDirector(directorId));
    }
}