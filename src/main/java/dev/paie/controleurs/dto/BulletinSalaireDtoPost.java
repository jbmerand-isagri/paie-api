package dev.paie.controleurs.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class BulletinSalaireDtoPost {

    @NotNull(message = "id non renseigné.")
    private Integer periodeId;
    @NotBlank(message = "matricule non renseigné")
    private String matriculeCode;
    @NotNull(message = "prime exceptionnelle non renseignée")
    private BigDecimal primeExceptionnelle;

    public BulletinSalaireDtoPost(Integer periodeId, String matriculeCode, BigDecimal primeExceptionnelle) {
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
