package br.com.douglasbello.cinelist.entities;

import br.com.douglasbello.cinelist.entities.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "directors")
public class Director extends Person {
    public Director() {}

    public Director(String firstName, String lastName, LocalDate birthDate, Gender gender) {
        super(firstName, lastName, birthDate, gender);
    }
}