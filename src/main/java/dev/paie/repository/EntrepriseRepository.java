package dev.paie.repository;

import dev.paie.entites.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, String> {

    Entreprise findByCodeIgnoreCase(String code);
}
