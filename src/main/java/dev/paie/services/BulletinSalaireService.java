package dev.paie.services;

import dev.paie.controleurs.dto.BulletinSalaireDto;
import dev.paie.entites.BulletinSalaire;
import dev.paie.entites.Periode;
import dev.paie.entites.RemunerationEmploye;
import dev.paie.exceptions.RemunerationEmployeInvalideException;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.utils.RemunerationEmployeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BulletinSalaireService {

    @Autowired
    private BulletinSalaireRepository bulletinSalaireRepository;
    @Autowired
    private RemunerationEmployeService remunerationEmployeService;
    @Autowired
    private PeriodeService periodeService;
    @Autowired
    private RemunerationEmployeValidator remunerationEmployeValidator;

    public void insererBulletinSalaire(BulletinSalaireDto bulletinSalaireDto) throws RemunerationEmployeInvalideException {
        // TODO : FINIR
        if(!remunerationEmployeValidator.isMatriculeExistant(bulletinSalaireDto.getMatriculeCode())) {
            throw new RemunerationEmployeInvalideException("ERREUR : matricule de l'employé introuvable.");
        }
        bulletinSalaireRepository.save(parseDtoToBulletinDeSalaire(bulletinSalaireDto));
    }

    public BulletinSalaire parseDtoToBulletinDeSalaire(BulletinSalaireDto dto) {

        RemunerationEmploye remunerationEmploye =
                remunerationEmployeService.recupererRemunerationEmployeParMatricule(dto.getMatriculeCode());
        Periode periode = periodeService.recupererPeriodeParSonId(dto.getPeriodeId());

        return new BulletinSalaire(remunerationEmploye,periode,dto.getPrimeExceptionnelle());
    }
}
