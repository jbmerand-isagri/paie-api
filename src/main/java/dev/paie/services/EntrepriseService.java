package dev.paie.services;

import dev.paie.controleurs.dto.EntrepriseDto;
import dev.paie.entites.Entreprise;
import dev.paie.repository.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntrepriseService {

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    public List<EntrepriseDto> recupererListeEntreprisesDto() {
        List<Entreprise> entreprises = entrepriseRepository.findAll();
        List<EntrepriseDto> entreprisesDto = new ArrayList<>();

        for (Entreprise e : entreprises) {
            entreprisesDto.add(new EntrepriseDto(e));
        }

        return entreprisesDto;
    }

    public Entreprise recupererUneEntrepriseParSonCode(String code) {
        return entrepriseRepository.findByCodeIgnoreCase(code);
    }
}
