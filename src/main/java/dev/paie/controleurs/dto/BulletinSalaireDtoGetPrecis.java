package dev.paie.controleurs.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;

public class BulletinSalaireDtoGetPrecis extends BulletinSalaireDtoGet{

    private BigDecimal baseSalaireDeBase;
    private BigDecimal tauxSalarialSalaireDeBase;
    private BigDecimal montantSalarialSalaireDeBase;

    public BulletinSalaireDtoGetPrecis(BigDecimal baseSalaireDeBase, BigDecimal tauxSalarialSalaireDeBase,
                                       BigDecimal montantSalarialSalaireDeBase) {
        this.baseSalaireDeBase = baseSalaireDeBase;
        this.tauxSalarialSalaireDeBase = tauxSalarialSalaireDeBase;
        this.montantSalarialSalaireDeBase = montantSalarialSalaireDeBase;
    }

    public BulletinSalaireDtoGetPrecis(Integer id, LocalDate dateDebut, LocalDate dateFin,
                                       BigDecimal primeExceptionnelle, ZonedDateTime dateHeureCreation,
                                       String matriculeCode, BigDecimal salaireBrut, BigDecimal netImposable,
                                       BigDecimal netAPayer, BigDecimal baseSalaireDeBase,
                                       BigDecimal tauxSalarialSalaireDeBase, BigDecimal montantSalarialSalaireDeBase) {
        super(id, dateDebut, dateFin, primeExceptionnelle, dateHeureCreation, matriculeCode, salaireBrut,
                netImposable, netAPayer);
        this.baseSalaireDeBase = baseSalaireDeBase;
        this.tauxSalarialSalaireDeBase = tauxSalarialSalaireDeBase;
        this.montantSalarialSalaireDeBase = montantSalarialSalaireDeBase;
    }

    public BigDecimal getBaseSalaireDeBase() {
        return baseSalaireDeBase;
    }

    public void setBaseSalaireDeBase(BigDecimal baseSalaireDeBase) {
        this.baseSalaireDeBase = baseSalaireDeBase;
    }

    public BigDecimal getTauxSalarialSalaireDeBase() {
        return tauxSalarialSalaireDeBase;
    }

    public void setTauxSalarialSalaireDeBase(BigDecimal tauxSalarialSalaireDeBase) {
        this.tauxSalarialSalaireDeBase = tauxSalarialSalaireDeBase;
    }

    public BigDecimal getMontantSalarialSalaireDeBase() {
        return montantSalarialSalaireDeBase;
    }

    public void setMontantSalarialSalaireDeBase(BigDecimal montantSalarialSalaireDeBase) {
        this.montantSalarialSalaireDeBase = montantSalarialSalaireDeBase;
    }
}
