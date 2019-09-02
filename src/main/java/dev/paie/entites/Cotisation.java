package dev.paie.entites;

import javax.persistence.*;
import java.math.BigDecimal;

// INSERT INTO cotisation (id, code, imposable, libelle, taux_patronal, taux_salarial) VALUES (1, 'SP01', true,
// 'URSSAF CSG NON DEDUCTIBLE', null, 0.024000);

@Entity
@Table(name="cotisation")
public class Cotisation {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="code")
	private String code;
	@Column(name="libelle")
	private String libelle;
	@Column(name="taux_salarial", precision = 7, scale = 6)
	private BigDecimal tauxSalarial;
	@Column(name="taux_patronal", precision = 7, scale = 6)
	private BigDecimal tauxPatronal;
	@Column(name="imposable")
	private Boolean imposable = false;
	
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getImposable() {
		return imposable;
	}
	public void setImposable(Boolean imposable) {
		this.imposable = imposable;
	}
}
