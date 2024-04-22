package br.com.douglasbello.cinelist.entities;

import br.com.douglasbello.cinelist.entities.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "actors")
public class Actor extends Person {
    public Actor() {}

    public Actor(String firstName, String lastName, LocalDate birthDate, Gender gender) {
        super(firstName, lastName, birthDate, gender);
    }
}