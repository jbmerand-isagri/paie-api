package dev.paie.controleurs.dto;

import dev.paie.entites.Cotisation;

import java.math.BigDecimal;

public class CotisationImposableDto {

    private String code;
    private String libelle;
    private BigDecimal tauxSalarial;
    private BigDecimal tauxPatronal;
    private BigDecimal montantSalarial;
    private BigDecimal cotisationsPatronales;
    private BigDecimal base;

    public CotisationImposableDto(BigDecimal salaireBrut, Cotisation cotisation) {
        this.base = salaireBrut;
        this.code = cotisation.getCode();
        this.libelle = cotisation.getLibelle();
        this.tauxSalarial = (cotisation.getTauxSalarial() == null) ? new BigDecimal("0") :
                cotisation.getTauxSalarial();
        this.tauxPatronal = (cotisation.getTauxPatronal() == null) ? new BigDecimal("0") :
                cotisation.getTauxPatronal();
        this.montantSalarial = base.multiply(tauxSalarial);
        this.cotisationsPatronales = base.multiply(tauxPatronal);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public BigDecimal getTauxSalarial() {
        return tauxSalarial;
    }

    public void setTauxSalarial(BigDecimal tauxSalarial) {
        this.tauxSalarial = tauxSalarial;
    }

    public BigDecimal getTauxPatronal() {
        return tauxPatronal;
    }

    public void setTauxPatronal(BigDecimal tauxPatronal) {
        this.tauxPatronal = tauxPatronal;
    }

    public BigDecimal getMontantSalarial() {
        return montantSalarial;
    }

    public void setMontantSalarial(BigDecimal montantSalarial) {
        this.montantSalarial = montantSalarial;
    }

    public BigDecimal getCotisationsPatronales() {
        return cotisationsPatronales;
    }

    public void setCotisationsPatronales(BigDecimal cotisationsPatronales) {
        this.cotisationsPatronales = cotisationsPatronales;
    }

    public BigDecimal getBase() {
        return base;
    }

    public void setBase(BigDecimal base) {
        this.base = base;
    }
}
