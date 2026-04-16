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
public class Fakultet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable= false)
	private String naziv;
	
	@ManyToOne(optional=false)
	private Univerzitet univerzitet;
	
	@OneToMany(mappedBy = "fakultet")
	private List<StudijskiProgram> studijskiProgrami=new ArrayList<StudijskiProgram>();
	
	@OneToMany(mappedBy = "fakultet")
	private List<AdministrativnoAngazovanje>administrativnoAngazovanje=new ArrayList<AdministrativnoAngazovanje>();
	
	public Fakultet() {
		super();
	}

	public Fakultet(Long id, String naziv, Univerzitet univerzitet, List<StudijskiProgram> studijskiProgrami,
			List<AdministrativnoAngazovanje> administrativnoAngazovanje) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.univerzitet = univerzitet;
		this.studijskiProgrami = studijskiProgrami;
		this.administrativnoAngazovanje = administrativnoAngazovanje;
	}

	public Fakultet(Long id, String naziv, Univerzitet univerzitet) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.univerzitet = univerzitet;
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

	public Univerzitet getUniverzitet() {
		return univerzitet;
	}

	public void setUniverzitet(Univerzitet univerzitet) {
		this.univerzitet = univerzitet;
	}

	public List<StudijskiProgram> getStudijskiProgrami() {
		return studijskiProgrami;
	}

	public void setStudijskiProgrami(List<StudijskiProgram> studijskiProgrami) {
		this.studijskiProgrami = studijskiProgrami;
	}

	public List<AdministrativnoAngazovanje> getAdministrativnoAngazovanje() {
		return administrativnoAngazovanje;
	}

	public void setAdministrativnoAngazovanje(List<AdministrativnoAngazovanje> administrativnoAngazovanje) {
		this.administrativnoAngazovanje = administrativnoAngazovanje;
	}
	
}
