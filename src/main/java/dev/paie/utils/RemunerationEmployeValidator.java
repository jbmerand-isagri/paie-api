package dev.paie.utils;

import dev.paie.controleurs.RemunerationEmployeDto;
import dev.paie.entites.RemunerationEmploye;
import dev.paie.services.RemunerationEmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

}
