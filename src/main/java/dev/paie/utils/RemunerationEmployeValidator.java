package dev.paie.utils;

import dev.paie.controleurs.dto.RemunerationEmployeDto;
import dev.paie.entites.RemunerationEmploye;
import dev.paie.exceptions.MatriculeInvalideException;
import dev.paie.services.RemunerationEmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Component
public class RemunerationEmployeValidator {

    @Autowired
    private RemunerationEmployeService remunerationEmployeService;

    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private Validator validator = factory.getValidator();

    public boolean validerUnObjetRemunerationEmployeDTO(RemunerationEmployeDto dto) {
        Set<ConstraintViolation<RemunerationEmployeDto>> violations = validator.validate(dto);
        return violations.size() == 0;
    }

    public boolean validerUnObjetRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
        Set<ConstraintViolation<RemunerationEmploye>> violations = validator.validate(remunerationEmploye);
        return violations.size() == 0;
    }

    public boolean isMatriculeExistant(String matricule) {
        return remunerationEmployeService.recupererRemunerationEmployeParMatricule(matricule) != null;
    }

    public boolean isMatriculeExistantSurCollegueApi(String matricule) throws MatriculeInvalideException {
        try {
            RestTemplate rt = new RestTemplate();
            Object result = rt.getForObject("https://jbmerand-collegues-api.herokuapp.com/collegues/" + matricule,
                    Object.class);
            return result != null;
        } catch (HttpClientErrorException e) {
            throw new MatriculeInvalideException("ERREUR : Matricule non trouvé sur collegues-api. \n" + e);
        }

    }

}
