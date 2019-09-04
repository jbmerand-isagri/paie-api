package dev.paie.controleurs.dto;

import java.util.List;

public class BulletinSalaireDtoGetFeuille {

    private BulletinSalaireDtoGetPrecis salaire;
    private EmployeDto employe;
    private CotisationsNonImposablesDtoGet cotisationsNonImposables;
    private List<CotisationImposableDto> cotisationsImposables;

    public BulletinSalaireDtoGetFeuille(BulletinSalaireDtoGetPrecis salaire, EmployeDto employe,
                                        CotisationsNonImposablesDtoGet cotisationsNonImposables,
                                        List<CotisationImposableDto> cotisationsImposables) {
        this.salaire = salaire;
        this.employe = employe;
        this.cotisationsNonImposables = cotisationsNonImposables;
        this.cotisationsImposables = cotisationsImposables;
    }

    public BulletinSalaireDtoGetPrecis getSalaire() {
        return salaire;
    }

    public void setSalaire(BulletinSalaireDtoGetPrecis salaire) {
        this.salaire = salaire;
    }

    public EmployeDto getEmploye() {
        return employe;
    }

    public void setEmploye(EmployeDto employe) {
        this.employe = employe;
    }

    public CotisationsNonImposablesDtoGet getCotisationsNonImposables() {
        return cotisationsNonImposables;
    }

    public void setCotisationsNonImposables(CotisationsNonImposablesDtoGet cotisationsNonImposables) {
        this.cotisationsNonImposables = cotisationsNonImposables;
    }

    public List<CotisationImposableDto> getCotisationsImposables() {
        return cotisationsImposables;
    }

    public void setCotisationsImposables(List<CotisationImposableDto> cotisationsImposables) {
        this.cotisationsImposables = cotisationsImposables;
    }
}
