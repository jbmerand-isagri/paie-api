package dev.paie.services;

import dev.paie.controleurs.dto.ProfilRemunerationDto;
import dev.paie.entites.ProfilRemuneration;
import dev.paie.repository.ProfilRemunerationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfilRemunerationService {

    @Autowired
    private ProfilRemunerationRepository profilRemunerationRepository;

    public List<ProfilRemunerationDto> recupererListeProfilRemunerationDto() {
        List<ProfilRemuneration> profilsRemuneration = profilRemunerationRepository.findAll();
        List<ProfilRemunerationDto> profilsRemunerationDto = new ArrayList<>();

        for (ProfilRemuneration p : profilsRemuneration) {
            profilsRemunerationDto.add(new ProfilRemunerationDto(p));
        }

        return profilsRemunerationDto;
    }

    public ProfilRemuneration recupererUnProfilRemunerationParSonCode(String code) {
        return profilRemunerationRepository.findByCodeIgnoreCase(code);
    }
}
