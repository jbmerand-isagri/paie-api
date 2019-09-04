package dev.paie.controleurs.dto;

import dev.paie.entites.Employe;

import java.time.LocalDate;

public class EmployeDto {

    private String matricule;
    private String nom;
    private String prenoms;
    private LocalDate dateDeNaissance;

    public EmployeDto(Employe employe) {
        this.matricule = employe.getMatricule();
        this.nom = employe.getNom();
        this.prenoms = employe.getPrenoms();
        this.dateDeNaissance = employe.getDateDeNaissance();
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
}
