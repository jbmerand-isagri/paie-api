package dev.paie.repository;

import dev.paie.entites.ProfilRemuneration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilRemunerationRepository extends JpaRepository<ProfilRemuneration, String> {

    ProfilRemuneration findByCodeIgnoreCase(String code);
}
