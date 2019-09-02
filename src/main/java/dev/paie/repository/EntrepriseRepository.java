package dev.paie.repository;

import com.sun.tools.javac.util.List;
import dev.paie.entites.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface EntrepriseRepository extends JpaRepository<Entreprise, String> {

}
