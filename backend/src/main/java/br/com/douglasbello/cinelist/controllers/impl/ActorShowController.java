package br.com.douglasbello.cinelist.controllers.impl;

import br.com.douglasbello.cinelist.entities.Actor;
import br.com.douglasbello.cinelist.entities.ActorShow;
import br.com.douglasbello.cinelist.entities.Show;
import br.com.douglasbello.cinelist.services.impl.ActorService;
import br.com.douglasbello.cinelist.services.impl.ActorShowService;
import br.com.douglasbello.cinelist.services.impl.ShowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ActorShowController {
    private final ActorShowService actorShowService;
    private final ActorService actorService;
    private final ShowService showService;

    public ActorShowController(final ActorShowService actorShowService, final ActorService actorService, final ShowService showService) {
        this.actorShowService = actorShowService;
        this.actorService = actorService;
        this.showService = showService;
    }

    @PostMapping("/shows/{showId}/add-actor/{actorId}")
    public ResponseEntity<List<Actor>> addActorToShow(@PathVariable String showId, @PathVariable String actorId, @RequestBody ActorShow actorShow) {
        actorShow.setActor(actorService.findById(actorId));
        actorShow.setShow(showService.findById(showId));

        return ResponseEntity.ok().body(actorShowService.addaActorToShow(actorShow));
    }

    @GetMapping("/shows/{showId}/actors")
    public ResponseEntity<List<Actor>> getActorsFromShow(@PathVariable String showId) {
        return ResponseEntity.ok().body(actorShowService.getActorsOfShow(showId));
    }

    @GetMapping("/actors/{actorId}/shows")
    public ResponseEntity<List<Show>> getShowsFromActor(@PathVariable String actorId) {
        return ResponseEntity.ok().body(actorShowService.getShowsOfActor(actorId));
    }
}