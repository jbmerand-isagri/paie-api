package dev.paie.controleurs;

import dev.paie.controleurs.dto.BulletinSalaireDtoGet;
import dev.paie.controleurs.dto.BulletinSalaireDtoGetFeuille;
import dev.paie.controleurs.dto.BulletinSalaireDtoPost;
import dev.paie.exceptions.BulletinSalaireException;
import dev.paie.exceptions.RemunerationEmployeInvalideException;
import dev.paie.services.BulletinSalaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BulletinSalaireControleur {

    @Autowired
    private BulletinSalaireService bulletinSalaireService;

    @PostMapping("/bulletins_salaire")
    public ResponseEntity<String> reqAjouterBulletinSalaire(@Valid @RequestBody BulletinSalaireDtoPost dto,
                                                            Errors errors) {
        if (errors.hasErrors()) {
            throw new BulletinSalaireException("ERREUR : au moins un des champs est mal renseigné. \n" + errors.getAllErrors());
        }
        bulletinSalaireService.insererBulletinSalaire(dto);
        return ResponseEntity.status(201).body("SUCCES : le bulletin a bien été créé.");
    }

    @RequestMapping(path = "/bulletins_salaire", method = RequestMethod.GET)
    public List<BulletinSalaireDtoGet> reqAfficherBulletinsSalaire() {
        return bulletinSalaireService.recupererListeBulletinsSalaireDtoGet();
    }

    @GetMapping("/bulletins_salaire/{id}")
    public BulletinSalaireDtoGetFeuille reqAfficherUnBulletinSalaire(@PathVariable Integer id) {
        return bulletinSalaireService.recupererBulletinSalaireDtoGetFeuilleAPartirIdBulletinSalaire(id);
    }

    @ExceptionHandler(RemunerationEmployeInvalideException.class)
    public ResponseEntity<String> handleException(RemunerationEmployeInvalideException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(BulletinSalaireException.class)
    public ResponseEntity<String> handleException(BulletinSalaireException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }

}
