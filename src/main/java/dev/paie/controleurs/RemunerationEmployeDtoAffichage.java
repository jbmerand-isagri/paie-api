package dev.paie.controleurs;

import dev.paie.entites.RemunerationEmploye;

import java.time.ZonedDateTime;

public class RemunerationEmployeDtoAffichage {

    private String matricule;
    private String gradeCode;
    private ZonedDateTime dateDeCreation;

    public RemunerationEmployeDtoAffichage() {
        super();
    }

    public RemunerationEmployeDtoAffichage (RemunerationEmploye remunerationEmploye) {

        this.matricule = remunerationEmploye.getMatricule();
        this.gradeCode = remunerationEmploye.getGrade().getCode();
        this.dateDeCreation = remunerationEmploye.getDateDeCreation();
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public ZonedDateTime getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(ZonedDateTime dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }
}
