package dev.paie.controleurs.dto;

import dev.paie.entites.Entreprise;

public class EntrepriseDto {

    private String code;
    private String denomination;

    public EntrepriseDto(Entreprise entreprise) {
        this.code = entreprise.getCode();
        this.denomination = entreprise.getDenomination();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }
}
