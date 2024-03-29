package dev.paie.entites;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "remuneration_employe")
public class RemunerationEmploye {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "matricule", unique = true)
    private String matricule;
    @Column(name = "date_de_creation")
    private ZonedDateTime dateDeCreation;
    @ManyToOne
    private Entreprise entreprise;
    @ManyToOne
    private ProfilRemuneration profilRemuneration;
    @ManyToOne
    private Grade grade;

    public RemunerationEmploye() {
        super();
    }

/*    public RemunerationEmploye(String matricule, ZonedDateTime dateDeCreation, Entreprise entreprise,
                               ProfilRemuneration profilRemuneration, Grade grade) {
        this.matricule = matricule;
        this.dateDeCreation = dateDeCreation;
        this.entreprise = entreprise;
        this.profilRemuneration = profilRemuneration;
        this.grade = grade;
    }*/

    public RemunerationEmploye(Integer id, String matricule, ZonedDateTime dateDeCreation, Entreprise entreprise,
                               ProfilRemuneration profilRemuneration,
                               Grade grade) {
        this.id = id;
        this.matricule = matricule;
        this.dateDeCreation = dateDeCreation;
        this.entreprise = entreprise;
        this.profilRemuneration = profilRemuneration;
        this.grade = grade;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public ProfilRemuneration getProfilRemuneration() {
        return profilRemuneration;
    }

    public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
        this.profilRemuneration = profilRemuneration;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ZonedDateTime getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(ZonedDateTime dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }
}
