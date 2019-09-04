package dev.paie.services;

import dev.paie.controleurs.dto.BulletinSalaireDtoGet;
import dev.paie.controleurs.dto.BulletinSalaireDtoPost;
import dev.paie.entites.BulletinSalaire;
import dev.paie.entites.Periode;
import dev.paie.entites.RemunerationEmploye;
import dev.paie.exceptions.RemunerationEmployeInvalideException;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.utils.BulletinSalaireUtils;
import dev.paie.utils.RemunerationEmployeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private BulletinSalaireUtils bulletinSalaireUtils;

    public void insererBulletinSalaire(BulletinSalaireDtoPost bulletinSalaireDtoPost) throws RemunerationEmployeInvalideException {
        if (!remunerationEmployeValidator.isMatriculeExistant(bulletinSalaireDtoPost.getMatriculeCode())) {
            throw new RemunerationEmployeInvalideException("ERREUR : matricule de l'employé introuvable.");
        }
        bulletinSalaireRepository.save(parseDtoToBulletinDeSalaire(bulletinSalaireDtoPost));
    }

    public BulletinSalaire parseDtoToBulletinDeSalaire(BulletinSalaireDtoPost dto) {

        RemunerationEmploye remunerationEmploye =
                remunerationEmployeService.recupererRemunerationEmployeParMatricule(dto.getMatriculeCode());
        Periode periode = periodeService.recupererPeriodeParSonId(dto.getPeriodeId());

        return new BulletinSalaire(remunerationEmploye, periode, dto.getPrimeExceptionnelle());
    }

    public List<BulletinSalaireDtoGet> recupererListeBulletinsSalaireDtoGet() {

        List<BulletinSalaireDtoGet> listeBulletinsSalaireDtoGet = new ArrayList<>();
        List<BulletinSalaire> listeBulletinsSalaire = bulletinSalaireRepository.findAll();

        for (BulletinSalaire bS : listeBulletinsSalaire) {

            String matricule = bS.getRemunerationEmploye().getMatricule();
            LocalDate dateDebut = bS.getPeriode().getDateDebut();
            LocalDate dateFin = bS.getPeriode().getDateFin();
            BigDecimal salaireBrut =
                    bulletinSalaireUtils.calculerSalaireBrut(bS.getRemunerationEmploye().getGrade().getTauxBase(),
                            bS.getRemunerationEmploye().getGrade().getNbHeuresBase(), bS.getPrimeExceptionnelle());

            BigDecimal netImposable = bulletinSalaireUtils.calculerNetImposable(salaireBrut,
                    bS.getRemunerationEmploye().getProfilRemuneration().getCotisations());
            BigDecimal netAPayer = bulletinSalaireUtils.calculerNetAPayer(netImposable,
                    bS.getRemunerationEmploye().getProfilRemuneration().getCotisations());

            salaireBrut = salaireBrut.setScale(2, RoundingMode.UP);
            netImposable = netImposable.setScale(2, RoundingMode.UP);
            netAPayer = netAPayer.setScale(2, RoundingMode.UP);

            listeBulletinsSalaireDtoGet.add(parseBulletinSalaireToDtoGet(bS, matricule, dateDebut, dateFin,
                    salaireBrut, netImposable, netAPayer));
        }

        return listeBulletinsSalaireDtoGet;

    }

    public BulletinSalaireDtoGet parseBulletinSalaireToDtoGet(BulletinSalaire bS, String matricule,
                                                              LocalDate dateDebut, LocalDate dateFin,
                                                              BigDecimal salaireBrut, BigDecimal netImposable,
                                                              BigDecimal netAPayer) {

        return new BulletinSalaireDtoGet(dateDebut, dateFin, bS.getPrimeExceptionnelle(), bS.getDateHeureCreation(),
                matricule, salaireBrut, netImposable, netAPayer);
    }

}
