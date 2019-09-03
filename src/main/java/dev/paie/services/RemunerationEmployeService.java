package dev.paie.services;

import dev.paie.controleurs.RemunerationEmployeDto;
import dev.paie.entites.Entreprise;
import dev.paie.entites.Grade;
import dev.paie.entites.ProfilRemuneration;
import dev.paie.entites.RemunerationEmploye;
import dev.paie.repository.RemunerationEmployeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemunerationEmployeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RemunerationEmployeService.class);

    @Autowired
    private RemunerationEmployeRepository remunerationEmployeRepository;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private ProfilRemunerationService profilRemunerationService;
    @Autowired
    private EntrepriseService entrepriseService;

    public void insererRemunerationEmployeAPartirDuDto(RemunerationEmployeDto dto) {
        // TODO : parser par un validator
        LOGGER.info("Lancement de ajouterRemunerationEmployeAPartirDuDto()");
        if(dto != null) {
            RemunerationEmployeDto remunerationEmployeDto = new RemunerationEmployeDto();
            RemunerationEmploye remunerationEmploye = parseToRemunerationEmploye(dto);
            remunerationEmployeRepository.save(remunerationEmploye);
        }
    }

    public RemunerationEmploye parseToRemunerationEmploye(RemunerationEmployeDto dto) {
        Grade grade = gradeService.recupererUnGradeParSonCode(dto.getGradeCode());
        ProfilRemuneration profilRemuneration =
                profilRemunerationService.recupererUnProfilRemunerationParSonCode(dto.getProfilRemunerationCode());
        Entreprise entreprise = entrepriseService.recupererUneEntrepriseParSonCode(dto.getEntrepriseCode());

        return new RemunerationEmploye(dto.getMatricule(), entreprise, profilRemuneration, grade);

    }
}
