package dev.paie.controleurs;

import dev.paie.controleurs.dto.GradeDto;
import dev.paie.services.GradeService;
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
public class GradeControleur {

    private static final Logger LOGGER = LoggerFactory.getLogger(GradeControleur.class);

    @Autowired
    private GradeService gradeService;

    @RequestMapping(path = "/grades", method = RequestMethod.GET)
    public ResponseEntity<List<GradeDto>> listeGrades() {
        LOGGER.info("Lancement de listeGrades()");
        return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(
                gradeService.recupererListeGradesDto()
        );
    }
}
