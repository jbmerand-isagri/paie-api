package dev.paie.repository;

import dev.paie.entites.BulletinSalaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BulletinSalaireRepository extends JpaRepository<BulletinSalaire, String> {

}
