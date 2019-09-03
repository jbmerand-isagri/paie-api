package dev.paie.controleurs;

import dev.paie.controleurs.dto.BulletinSalaireDto;
import dev.paie.exceptions.RemunerationEmployeInvalideException;
import dev.paie.services.BulletinSalaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BulletinSalaireControleur {

    @Autowired
    private BulletinSalaireService bulletinSalaireService;

    @PostMapping("/bulletins_salaire")
    public ResponseEntity<String> reqAjouterBulletinSalaire(@RequestBody BulletinSalaireDto dto) {
        bulletinSalaireService.insererBulletinSalaire(dto);
        return ResponseEntity.status(201).body("SUCCES : le bulletin a bien été créé.");
    }

    @ExceptionHandler(RemunerationEmployeInvalideException.class)
    public ResponseEntity<String> handleException(RemunerationEmployeInvalideException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }

}
