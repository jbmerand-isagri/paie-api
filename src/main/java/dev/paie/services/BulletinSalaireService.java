package dev.paie.services;

import dev.paie.controleurs.dto.*;
import dev.paie.entites.*;
import dev.paie.exceptions.BulletinSalaireException;
import dev.paie.exceptions.RemunerationEmployeInvalideException;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.utils.BulletinSalaireUtils;
import dev.paie.utils.RemunerationEmployeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BulletinSalaireService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BulletinSalaireService.class);

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
    @Autowired
    private CotisationService cotisationService;

    public void insererBulletinSalaire(BulletinSalaireDtoPost bulletinSalaireDtoPost) throws RemunerationEmployeInvalideException {
        LOGGER.info("insererBulletinSalaire() lancé");
        if (!remunerationEmployeValidator.isMatriculeExistant(bulletinSalaireDtoPost.getMatriculeCode())) {
            LOGGER.info("RemunerationEmployeInvalideException lancée");
            throw new RemunerationEmployeInvalideException("ERREUR : matricule de l'employé introuvable.");
        }
        bulletinSalaireRepository.save(parseDtoToBulletinDeSalaire(bulletinSalaireDtoPost));
    }

    public BulletinSalaire parseDtoToBulletinDeSalaire(BulletinSalaireDtoPost dto) {
        LOGGER.info("parseDtoToBulletinDeSalaire lancé");
        RemunerationEmploye remunerationEmploye =
                remunerationEmployeService.recupererRemunerationEmployeParMatricule(dto.getMatriculeCode());
        Periode periode = periodeService.recupererPeriodeParSonId(dto.getPeriodeId());

        return new BulletinSalaire(remunerationEmploye, periode, dto.getPrimeExceptionnelle());
    }

    @Secured("ROLE_ADMIN")
    public List<BulletinSalaireDtoGet> recupererListeBulletinsSalaireDtoGet() {
        LOGGER.info("recupererListeBulletinsSalaireDtoGet lancé");

        List<BulletinSalaireDtoGet> listeBulletinsSalaireDtoGet = new ArrayList<>();
        List<BulletinSalaire> listeBulletinsSalaire = bulletinSalaireRepository.findAll();

        for (BulletinSalaire bS : listeBulletinsSalaire) {

            String matricule = bS.getRemunerationEmploye().getMatricule();
            LocalDate dateDebut = bS.getPeriode().getDateDebut();
            LocalDate dateFin = bS.getPeriode().getDateFin();
            BigDecimal salaireBrut =
                    bulletinSalaireUtils.calculerSalaireBrut(bS.getRemunerationEmploye().getGrade().getTauxBase(),
                            bS.getRemunerationEmploye().getGrade().getNbHeuresBase(), bS.getPrimeExceptionnelle());
            salaireBrut = salaireBrut.setScale(2, RoundingMode.UP);

            BigDecimal netImposable = bulletinSalaireUtils.calculerNetImposable(salaireBrut,
                    bS.getRemunerationEmploye().getProfilRemuneration().getCotisations());
            netImposable = netImposable.setScale(2, RoundingMode.UP);

            BigDecimal netAPayer = bulletinSalaireUtils.calculerNetAPayer(netImposable,
                    bS.getRemunerationEmploye().getProfilRemuneration().getCotisations());
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
        LOGGER.info("parseBulletinSalaireToDtoGet lancé");

        return new BulletinSalaireDtoGet(bS.getId(), dateDebut, dateFin, bS.getPrimeExceptionnelle(),
                bS.getDateHeureCreation(), matricule, salaireBrut, netImposable, netAPayer);
    }

    public Employe recupererDonneesUnEmployeParMatricule(String matricule) {
        LOGGER.info("recupererDonneesEmploye lancé, matricule = " + matricule);

        try {
            RestTemplate rt = new RestTemplate();

            Employe employe = rt.getForObject("https://jbmerand-collegues-api.herokuapp.com/collegues/" + matricule,
                    Employe.class);
            LOGGER.info("employé récupéré = " + employe);
            LOGGER.info("employe = " + employe);
            return employe;

        } catch (HttpClientErrorException e) {
            LOGGER.info("BulletinSalaireException lancée");
            throw new BulletinSalaireException("ERREUR : Echec de la récupération de l'employé à partir de " +
                    "collegues-api. \n" + e);
        }
    }

    public BulletinSalaireDtoGetPrecis recupererBulletinSalaireDtoGetPrecis(Integer idBulletinSalaire) {
        LOGGER.info("recupererBulletinSalaireDtoGetPrecis lancé");

        BulletinSalaire bS =
                bulletinSalaireRepository.findById(idBulletinSalaire).orElseThrow(() -> new BulletinSalaireException(
                        "ERREUR : id non trouvé dans la base de données."));

        String matricule = bS.getRemunerationEmploye().getMatricule();
        LocalDate dateDebut = bS.getPeriode().getDateDebut();
        LocalDate dateFin = bS.getPeriode().getDateFin();
        BigDecimal tauxBase = bS.getRemunerationEmploye().getGrade().getTauxBase();
        BigDecimal nbHeuresBase = bS.getRemunerationEmploye().getGrade().getNbHeuresBase();
        List<Cotisation> cotisations = bS.getRemunerationEmploye().getProfilRemuneration().getCotisations();
        BigDecimal primeExceptionnelle = bS.getPrimeExceptionnelle();

        BigDecimal salaireBrut =
                bulletinSalaireUtils.calculerSalaireBrut(tauxBase, nbHeuresBase, primeExceptionnelle);
        salaireBrut = salaireBrut.setScale(2, RoundingMode.UP);
        BigDecimal netImposable = bulletinSalaireUtils.calculerNetImposable(salaireBrut, cotisations);
        netImposable = netImposable.setScale(2, RoundingMode.UP);
        BigDecimal netAPayer = bulletinSalaireUtils.calculerNetAPayer(netImposable, cotisations);
        netAPayer = netAPayer.setScale(2, RoundingMode.UP);

        BigDecimal salaireDeBase = tauxBase.multiply(nbHeuresBase);

        salaireDeBase = salaireDeBase.setScale(2, RoundingMode.UP);

        return new BulletinSalaireDtoGetPrecis(idBulletinSalaire, dateDebut, dateFin, primeExceptionnelle,
                bS.getDateHeureCreation(), matricule, salaireBrut, netImposable, netAPayer, nbHeuresBase, tauxBase,
                salaireDeBase);
    }

    public BulletinSalaireDtoGetFeuille recupererBulletinSalaireDtoGetFeuilleAPartirIdBulletinSalaire(Integer idBulletinSalaire) {
        LOGGER.info("recupererBulletinSalaireDtoGetFeuilleAPartirIdBulletinSalaire lancé");

        BulletinSalaireDtoGetPrecis bulletinPrecis = recupererBulletinSalaireDtoGetPrecis(idBulletinSalaire);

        Employe employe = recupererDonneesUnEmployeParMatricule(bulletinPrecis.getMatriculeCode());
        EmployeDto employeDto = new EmployeDto(employe);

        List<Cotisation> cotisations = cotisationService.recupererCotisationsParMatriculeEmploye(employeDto.getMatricule());

        List<CotisationNonImposableDtoGet> cotisationsNonImposableDtoGet = new ArrayList<>();
        for (Cotisation c : cotisations) {
            cotisationsNonImposableDtoGet.add(new CotisationNonImposableDtoGet(c, bulletinPrecis.getSalaireBrut()));
        }

        BigDecimal totalRetenueMontantSalarial = bulletinSalaireUtils.calculerTotalRetenueMontantSalarialNonImposables(cotisations
                , bulletinPrecis.getSalaireBrut());
        BigDecimal totalRetenueCotisationsPatronales =
                bulletinSalaireUtils.calculerTotalRetenueCotisationsPatronalesNonImposables(cotisations,
                        bulletinPrecis.getSalaireBrut());
        CotisationsNonImposablesDtoGet cotisationsNonImposablesDtoGet =
                new CotisationsNonImposablesDtoGet(cotisationsNonImposableDtoGet, totalRetenueMontantSalarial, totalRetenueCotisationsPatronales);

        List<CotisationImposableDto> cotisationImposables = new ArrayList<>();

        for (Cotisation c : cotisations) {
            cotisationImposables.add(new CotisationImposableDto(bulletinPrecis.getSalaireBrut(), c));
        }

        BulletinSalaireDtoGetFeuille bulletinSalaireDtoGetFeuille =
                new BulletinSalaireDtoGetFeuille(bulletinPrecis, employeDto, cotisationsNonImposablesDtoGet, cotisationImposables);

        return bulletinSalaireDtoGetFeuille;
    }

}
