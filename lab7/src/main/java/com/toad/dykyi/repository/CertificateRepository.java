package com.toad.dykyi.repository;

import com.toad.dykyi.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    Optional<Certificate> findByCode(String code);
}
