package dev.paie.controleurs.dto;

import javax.validation.constraints.NotEmpty;
import java.time.ZonedDateTime;

public class RemunerationEmployeDto {

    @NotEmpty
    private String matricule;
    @NotEmpty
    private String entrepriseCode;
    @NotEmpty
    private String profilRemunerationCode;
    @NotEmpty
    private String gradeCode;
    private ZonedDateTime dateDeCreation;

    public RemunerationEmployeDto() {
        super();
    }

    public RemunerationEmployeDto(String matricule, String entrepriseCode, String profilRemunerationCode,
                                  String gradeCode) {
        this.matricule = matricule;
        this.entrepriseCode = entrepriseCode;
        this.profilRemunerationCode = profilRemunerationCode;
        this.gradeCode = gradeCode;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getEntrepriseCode() {
        return entrepriseCode;
    }

    public void setEntrepriseCode(String entrepriseCode) {
        this.entrepriseCode = entrepriseCode;
    }

    public String getProfilRemunerationCode() {
        return profilRemunerationCode;
    }

    public void setProfilRemunerationCode(String profilRemunerationCode) {
        this.profilRemunerationCode = profilRemunerationCode;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }
}
