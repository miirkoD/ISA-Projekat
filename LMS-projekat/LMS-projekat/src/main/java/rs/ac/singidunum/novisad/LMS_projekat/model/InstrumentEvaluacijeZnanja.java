package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class InstrumentEvaluacijeZnanja {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@OneToMany(mappedBy = "instrumentEvaluacijeZnanja")
	private List<NastavniMaterijal> nastavniMaterijali = new ArrayList<NastavniMaterijal>();
	
	@OneToMany(mappedBy = "instrumentEvaluacijeZnanja")
	private List<EvaluacijaZnanja> evaluacijaZnanja=new ArrayList<EvaluacijaZnanja>();

	public InstrumentEvaluacijeZnanja() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InstrumentEvaluacijeZnanja(Long id, String naziv, List<NastavniMaterijal> nastavniMaterijali,
			List<EvaluacijaZnanja> evaluacijaZnanja) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.nastavniMaterijali = nastavniMaterijali;
		this.evaluacijaZnanja = evaluacijaZnanja;
	}

	public InstrumentEvaluacijeZnanja(Long id, String naziv) {
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

	public List<NastavniMaterijal> getNastavniMaterijali() {
		return nastavniMaterijali;
	}

	public void setNastavniMaterijali(List<NastavniMaterijal> nastavniMaterijali) {
		this.nastavniMaterijali = nastavniMaterijali;
	}

	public List<EvaluacijaZnanja> getEvaluacijaZnanja() {
		return evaluacijaZnanja;
	}

	public void setEvaluacijaZnanja(List<EvaluacijaZnanja> evaluacijaZnanja) {
		this.evaluacijaZnanja = evaluacijaZnanja;
	}

}
