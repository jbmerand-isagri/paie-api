package dev.paie.repository;

import dev.paie.entites.RemunerationEmploye;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemunerationEmployeRepository extends JpaRepository<RemunerationEmploye, String> {

}
