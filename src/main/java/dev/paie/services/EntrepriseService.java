package dev.paie.services;

import dev.paie.controleurs.EntrepriseDto;
import dev.paie.entites.Entreprise;
import dev.paie.repository.EntrepriseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntrepriseService {

    private final EntrepriseRepository entrepriseRepository;

    public EntrepriseService(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    public List<EntrepriseDto> recupererListeEntreprisesDto() {
        List<Entreprise> entreprises = entrepriseRepository.findAll();
        List<EntrepriseDto> entreprisesDto = new ArrayList<>();

        for (Entreprise e : entreprises) {
            entreprisesDto.add(new EntrepriseDto(e));
        }

        return entreprisesDto;
    }
}
