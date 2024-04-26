package br.com.douglasbello.cinelist.controllers.impl;

import br.com.douglasbello.cinelist.controllers.Controller;
import br.com.douglasbello.cinelist.entities.Actor;
import br.com.douglasbello.cinelist.services.Service;
import br.com.douglasbello.cinelist.services.impl.ActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/actors")
public class ActorController implements Controller<Actor> {
    public final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @Override
    public Service<Actor> getService() {
        return actorService;
    }

    @PostMapping
    public ResponseEntity<Actor> insert(@RequestBody Actor actor) {
        actor = actorService.save(actor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(actor.getId()).toUri();

        return ResponseEntity.created(uri).body(actor);
    }
}