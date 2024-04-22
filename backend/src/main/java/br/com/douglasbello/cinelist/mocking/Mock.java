package br.com.douglasbello.cinelist.mocking;

import br.com.douglasbello.cinelist.entities.Actor;
import br.com.douglasbello.cinelist.entities.enums.Gender;
import br.com.douglasbello.cinelist.services.impl.ActorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

public class Mock implements CommandLineRunner {
    private final ActorService actorService;

    public Mock(final ActorService actorService) {
        this.actorService = actorService;
    }

    @Override
    public void run(final String... args) throws Exception {
        LocalDate date = LocalDate.of(1980, 11, 12);
        Actor actor = new Actor("Ryan", "Gosling", date, Gender.MALE);
        actorService.save(actor);
    }
}