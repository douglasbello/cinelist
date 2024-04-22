package br.com.douglasbello.cinelist.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "artists")
public class Actor extends Person {
}