package dev.paie.services;

import dev.paie.controleurs.RemunerationEmployeDto;
import dev.paie.entites.Entreprise;
import dev.paie.entites.Grade;
import dev.paie.entites.ProfilRemuneration;
import dev.paie.entites.RemunerationEmploye;
import dev.paie.exceptions.RemunerationEmployeInvalideException;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.utils.RemunerationEmployeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemunerationEmployeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RemunerationEmployeService.class);

    @Autowired
    private RemunerationEmployeValidator remunerationEmployeValidator;
    @Autowired
    private RemunerationEmployeRepository remunerationEmployeRepository;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private ProfilRemunerationService profilRemunerationService;
    @Autowired
    private EntrepriseService entrepriseService;

    public void insererRemunerationEmployeAPartirDuDto(RemunerationEmployeDto dto) throws RemunerationEmployeInvalideException {
        LOGGER.info("Lancement de ajouterRemunerationEmployeAPartirDuDto()");
        if(dto != null) {
            if(remunerationEmployeValidator.validerUnObjetRemunerationEmployeDTO(dto)) {
                if(!remunerationEmployeValidator.isMatriculeExistant(dto.getMatricule())) {
                    RemunerationEmployeDto remunerationEmployeDto = new RemunerationEmployeDto();
                    RemunerationEmploye remunerationEmploye = parseToRemunerationEmploye(dto);
                    remunerationEmployeRepository.save(remunerationEmploye);
                } else throw new RemunerationEmployeInvalideException("ERREUR : Ce matricule est déjà présent.");
            } else {
                throw new RemunerationEmployeInvalideException("ERREUR : Données incorrectes (données manquantes...)");
            }
        }
    }

    public RemunerationEmploye parseToRemunerationEmploye(RemunerationEmployeDto dto) throws RemunerationEmployeInvalideException{
        Grade grade = gradeService.recupererUnGradeParSonCode(dto.getGradeCode());
        ProfilRemuneration profilRemuneration =
                profilRemunerationService.recupererUnProfilRemunerationParSonCode(dto.getProfilRemunerationCode());
        Entreprise entreprise = entrepriseService.recupererUneEntrepriseParSonCode(dto.getEntrepriseCode());
        if(grade != null && profilRemuneration != null && entreprise != null) {
            return new RemunerationEmploye(dto.getMatricule(), entreprise, profilRemuneration, grade);
        } else {
            throw new RemunerationEmployeInvalideException("ERREUR : Données incorrectes (données manquantes...)");
        }
    }

    public RemunerationEmploye recupererRemunerationEmployeParMatricule(String matricule) {
        return remunerationEmployeRepository.findByMatricule(matricule);
    }
}
