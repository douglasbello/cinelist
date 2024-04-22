package br.com.douglasbello.cinelist.services.impl;

import br.com.douglasbello.cinelist.entities.Certificate;
import br.com.douglasbello.cinelist.repositories.CertificateRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CertificateService implements br.com.douglasbello.cinelist.services.Service<Certificate> {
    private final CertificateRepository certificateRepository;

    public CertificateService(final CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    @Override
    public JpaRepository<Certificate, String> getRepository() {
        return certificateRepository;
    }
}