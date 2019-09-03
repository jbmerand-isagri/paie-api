package dev.paie.controleurs;

import dev.paie.controleurs.dto.ProfilRemunerationDto;
import dev.paie.services.ProfilRemunerationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfilRemunerationControleur {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfilRemunerationControleur.class);

    @Autowired
    private ProfilRemunerationService profilRemunerationService;

    @RequestMapping(path = "/profils_remuneration", method = RequestMethod.GET)
    public ResponseEntity<List<ProfilRemunerationDto>> listeProfils() {
        LOGGER.info("Lancement de listeProfils()");
        return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(
                profilRemunerationService.recupererListeProfilRemunerationDto()
        );
    }

}
