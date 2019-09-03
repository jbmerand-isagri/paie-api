package dev.paie.controleurs;

import dev.paie.entites.Grade;
import dev.paie.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class GradeDto {

    @Autowired
    private GradeService gradeService;

    private String code;
    private BigDecimal nbHeuresBase;
    private BigDecimal tauxBase;

    public GradeDto(Grade grade) {
        this.code = grade.getCode();
        this.nbHeuresBase = grade.getNbHeuresBase();
        this.tauxBase = grade.getTauxBase();
    }

    public Grade gradeDtoToGradeWithCode(GradeDto gradeDto) {
        return gradeService.recupererUnGradeParSonCode(gradeDto.getCode());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getNbHeuresBase() {
        return nbHeuresBase;
    }

    public void setNbHeuresBase(BigDecimal nbHeuresBase) {
        this.nbHeuresBase = nbHeuresBase;
    }

    public BigDecimal getTauxBase() {
        return tauxBase;
    }

    public void setTauxBase(BigDecimal tauxBase) {
        this.tauxBase = tauxBase;
    }
}
