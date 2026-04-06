package rs.ac.singidunum.novisad.LMS_projekat.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TipEvaluacijeZnanja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@OneToMany(mappedBy = "tipEvaluacijeZnanja")
	private List<EvaluacijaZnanja> evaluacijeZnanja = new ArrayList<EvaluacijaZnanja>();

	public TipEvaluacijeZnanja() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipEvaluacijeZnanja(Long id, String naziv, List<EvaluacijaZnanja> evaluacijeZnanja) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.evaluacijeZnanja = evaluacijeZnanja;
	}

	public TipEvaluacijeZnanja(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<EvaluacijaZnanja> getEvaluacijeZnanja() {
		return evaluacijeZnanja;
	}

	public void setEvaluacijeZnanja(List<EvaluacijaZnanja> evaluacijeZnanja) {
		this.evaluacijeZnanja = evaluacijeZnanja;
	}

}
