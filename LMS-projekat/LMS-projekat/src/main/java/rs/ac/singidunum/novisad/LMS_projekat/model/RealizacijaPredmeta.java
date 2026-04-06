package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class RealizacijaPredmeta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional = false)
	private Predmet predmet;
	
	@ManyToOne(optional = false)
	private SkolskaGodina skolskaGodina;
	
	@OneToMany(mappedBy = "realizacijaPredmeta")
	private List<EvaluacijaZnanja> evaluacijeZnanja=new ArrayList<EvaluacijaZnanja>();
	
	@OneToMany(mappedBy = "realizacijaPredmeta")
	private List<Angazovanje>angazovanja=new ArrayList<Angazovanje>();
	
	@OneToMany(mappedBy = "realizacijaPredmeta")
	private List<TerminNastave> terminiNastave=new ArrayList<TerminNastave>();
	
	@OneToMany(mappedBy = "realizacijaPredmeta")
	private List<NastavniMaterijal>nastavniMaterijali=new ArrayList<NastavniMaterijal>();	
	
	@OneToMany(mappedBy = "realizacijaPredmeta")
	private List<Pohadjanje> pohadjanje= new ArrayList<Pohadjanje>();

	public RealizacijaPredmeta() {
		super();
	}

	public RealizacijaPredmeta(Long id, Predmet predmet, SkolskaGodina skolskaGodina,
			List<EvaluacijaZnanja> evaluacijeZnanja, List<Angazovanje> angazovanja, List<TerminNastave> terminiNastave,
			List<NastavniMaterijal> nastavniMaterijali, List<Pohadjanje> pohadjanje) {
		super();
		this.id = id;
		this.predmet = predmet;
		this.skolskaGodina = skolskaGodina;
		this.evaluacijeZnanja = evaluacijeZnanja;
		this.angazovanja = angazovanja;
		this.terminiNastave = terminiNastave;
		this.nastavniMaterijali = nastavniMaterijali;
		this.pohadjanje = pohadjanje;
	}

	public RealizacijaPredmeta(Long id, Predmet predmet, SkolskaGodina skolskaGodina) {
		super();
		this.id = id;
		this.predmet = predmet;
		this.skolskaGodina = skolskaGodina;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public SkolskaGodina getSkolskaGodina() {
		return skolskaGodina;
	}

	public void setSkolskaGodina(SkolskaGodina skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}

	public List<EvaluacijaZnanja> getEvaluacijeZnanja() {
		return evaluacijeZnanja;
	}

	public void setEvaluacijeZnanja(List<EvaluacijaZnanja> evaluacijeZnanja) {
		this.evaluacijeZnanja = evaluacijeZnanja;
	}

	public List<Angazovanje> getAngazovanja() {
		return angazovanja;
	}

	public void setAngazovanja(List<Angazovanje> angazovanja) {
		this.angazovanja = angazovanja;
	}

	public List<TerminNastave> getTerminiNastave() {
		return terminiNastave;
	}

	public void setTerminiNastave(List<TerminNastave> terminiNastave) {
		this.terminiNastave = terminiNastave;
	}

	public List<NastavniMaterijal> getNastavniMaterijali() {
		return nastavniMaterijali;
	}

	public void setNastavniMaterijali(List<NastavniMaterijal> nastavniMaterijali) {
		this.nastavniMaterijali = nastavniMaterijali;
	}

	public List<Pohadjanje> getPohadjanje() {
		return pohadjanje;
	}

	public void setPohadjanje(List<Pohadjanje> pohadjanje) {
		this.pohadjanje = pohadjanje;
	}
	
}
