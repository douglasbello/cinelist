package br.com.douglasbello.cinelist.repositories;

import br.com.douglasbello.cinelist.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, String> {
}