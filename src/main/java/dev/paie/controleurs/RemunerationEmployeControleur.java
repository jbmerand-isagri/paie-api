package dev.paie.controleurs;

import dev.paie.controleurs.dto.RemunerationEmployeDto;
import dev.paie.controleurs.dto.RemunerationEmployeDtoAffichage;
import dev.paie.exceptions.MatriculeInvalideException;
import dev.paie.exceptions.RemunerationEmployeInvalideException;
import dev.paie.services.RemunerationEmployeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RemunerationEmployeControleur {

    private static final Logger LOGGER = LoggerFactory.getLogger(RemunerationEmployeControleur.class);

    @Autowired
    private RemunerationEmployeService remunerationEmployeService;

    @PostMapping("/remuneration_employes")
    public ResponseEntity<String> reqAjouterRemunerationEmploye(@RequestBody RemunerationEmployeDto dto) {

        LOGGER.info("lancement de reqAjouterRemunerationEmploye");
        remunerationEmployeService.insererRemunerationEmployeAPartirDuDto(dto);

        return ResponseEntity.status(201).body("SUCCES : l'employé a bien été ajouté.");
    }

    @RequestMapping(path = "/remuneration_employes", method = RequestMethod.GET)
    public List<RemunerationEmployeDtoAffichage> afficherLaListeDesRemunerationsEmployes() {

        LOGGER.info("lancement de afficherLaListeDesRemunerationsEmployes");
        return remunerationEmployeService.recupererListeDesRemunerationEmployesDtoAffichage();
    }

    @ExceptionHandler(RemunerationEmployeInvalideException.class)
    public ResponseEntity<String> handleException(RemunerationEmployeInvalideException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(MatriculeInvalideException.class)
    public ResponseEntity<String> handleException(MatriculeInvalideException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }

}