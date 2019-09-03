package dev.paie.repository;

import dev.paie.entites.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, String> {

    Grade findByCodeIgnoreCase(String code);
}
