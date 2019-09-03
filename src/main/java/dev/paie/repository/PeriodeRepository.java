package dev.paie.repository;

import dev.paie.entites.Periode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodeRepository extends JpaRepository<Periode, String> {

    Periode findById(Integer id);
}
