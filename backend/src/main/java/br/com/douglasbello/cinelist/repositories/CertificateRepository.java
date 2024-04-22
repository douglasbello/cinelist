package br.com.douglasbello.cinelist.repositories;

import br.com.douglasbello.cinelist.entities.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate, String> {
}