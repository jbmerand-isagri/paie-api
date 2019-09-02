package dev.paie.entites;

import javax.persistence.*;
import java.math.BigDecimal;

// INSERT INTO grade (id, code, nb_heures_base, taux_base) VALUES (1, 'GRADE_A', 152, 11);

@Entity
@Table(name="grade")
public class Grade {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="code")
	private String code;
	@Column(name="nb_heures_base")
	private BigDecimal nbHeuresBase;
	@Column(name="taux_base")
	private BigDecimal tauxBase;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getNbHeuresBase() {
		return nbHeuresBase;
	}
	public void setNbHeuresBase(BigDecimal nbHeuresBase) {
		this.nbHeuresBase = nbHeuresBase;
	}
	public BigDecimal getTauxBase() {
		return tauxBase;
	}
	public void setTauxBase(BigDecimal tauxBase) {
		this.tauxBase = tauxBase;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
