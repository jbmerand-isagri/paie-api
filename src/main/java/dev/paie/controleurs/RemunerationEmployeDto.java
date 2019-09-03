package dev.paie.controleurs;

public class RemunerationEmployeDto {

    private String matricule;
    private String entrepriseCode;
    private String profilRemunerationCode;
    private String gradeCode;

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
