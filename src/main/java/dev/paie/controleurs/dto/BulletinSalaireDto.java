package dev.paie.controleurs.dto;

import java.math.BigDecimal;

public class BulletinSalaireDto {

    private Integer periodeId;
    private String matriculeCode;
    private BigDecimal primeExceptionnelle;

    public BulletinSalaireDto(Integer periodeId, String matriculeCode, BigDecimal primeExceptionnelle) {
        this.periodeId = periodeId;
        this.matriculeCode = matriculeCode;
        this.primeExceptionnelle = primeExceptionnelle;
    }

    public Integer getPeriodeId() {
        return periodeId;
    }

    public void setPeriodeId(Integer periodeId) {
        this.periodeId = periodeId;
    }

    public String getMatriculeCode() {
        return matriculeCode;
    }

    public void setMatriculeCode(String matriculeCode) {
        this.matriculeCode = matriculeCode;
    }

    public BigDecimal getPrimeExceptionnelle() {
        return primeExceptionnelle;
    }

    public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
        this.primeExceptionnelle = primeExceptionnelle;
    }

}
