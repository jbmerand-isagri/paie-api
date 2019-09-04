package dev.paie.controleurs.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;

public class BulletinSalaireDtoGet {

    protected Integer id;
    protected LocalDate dateDebut;
    protected LocalDate dateFin;
    protected BigDecimal primeExceptionnelle;
    protected ZonedDateTime dateHeureCreation;
    protected String matriculeCode;
    protected BigDecimal salaireBrut;
    protected BigDecimal netImposable;
    protected BigDecimal netAPayer;

    public BulletinSalaireDtoGet() {
        super();
    }

    public BulletinSalaireDtoGet(Integer id, LocalDate dateDebut, LocalDate dateFin, BigDecimal primeExceptionnelle,
                                 ZonedDateTime dateHeureCreation, String matriculeCode, BigDecimal salaireBrut,
                                 BigDecimal netImposable, BigDecimal netAPayer) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.primeExceptionnelle = primeExceptionnelle;
        this.dateHeureCreation = dateHeureCreation;
        this.matriculeCode = matriculeCode;
        this.salaireBrut = salaireBrut;
        this.netImposable = netImposable;
        this.netAPayer = netAPayer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public BigDecimal getPrimeExceptionnelle() {
        return primeExceptionnelle;
    }

    public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
        this.primeExceptionnelle = primeExceptionnelle;
    }

    public ZonedDateTime getDateHeureCreation() {
        return dateHeureCreation;
    }

    public void setDateHeureCreation(ZonedDateTime dateHeureCreation) {
        this.dateHeureCreation = dateHeureCreation;
    }

    public String getMatriculeCode() {
        return matriculeCode;
    }

    public void setMatriculeCode(String matriculeCode) {
        this.matriculeCode = matriculeCode;
    }

    public BigDecimal getSalaireBrut() {
        return salaireBrut;
    }

    public void setSalaireBrut(BigDecimal salaireBrut) {
        this.salaireBrut = salaireBrut;
    }

    public BigDecimal getNetImposable() {
        return netImposable;
    }

    public void setNetImposable(BigDecimal netImposable) {
        this.netImposable = netImposable;
    }

    public BigDecimal getNetAPayer() {
        return netAPayer;
    }

    public void setNetAPayer(BigDecimal netAPayer) {
        this.netAPayer = netAPayer;
    }
}
