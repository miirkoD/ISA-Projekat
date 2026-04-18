package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class StudijskiProgram {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@ManyToOne(optional=false)
	private Fakultet fakultet;
	
	@OneToMany(mappedBy = "studijskiProgram")
	private List<GodinaStudija> godineStudija=new ArrayList<GodinaStudija>();
	
	@OneToMany(mappedBy = "studijskiProgram")
	private List<AdministrativnoAngazovanje> administrativnoAngazovanje=new ArrayList<AdministrativnoAngazovanje>();
	
	public StudijskiProgram() {
		super();
	}

	public StudijskiProgram(Long id, String naziv, Fakultet fakultet, List<GodinaStudija> godineStudija,
			List<AdministrativnoAngazovanje> administrativnoAngazovanje) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.fakultet = fakultet;
		this.godineStudija = godineStudija;
		this.administrativnoAngazovanje = administrativnoAngazovanje;
	}

	public StudijskiProgram(Long id, String naziv, Fakultet fakultet) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.fakultet = fakultet;
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

	public Fakultet getFakultet() {
		return fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}

	public List<GodinaStudija> getGodineStudija() {
		return godineStudija;
	}

	public void setGodineStudija(List<GodinaStudija> godineStudija) {
		this.godineStudija = godineStudija;
	}

	public List<AdministrativnoAngazovanje> getAdministrativnoAngazovanje() {
		return administrativnoAngazovanje;
	}

	public void setAdministrativnoAngazovanje(List<AdministrativnoAngazovanje> administrativnoAngazovanje) {
		this.administrativnoAngazovanje = administrativnoAngazovanje;
	}
	
}
