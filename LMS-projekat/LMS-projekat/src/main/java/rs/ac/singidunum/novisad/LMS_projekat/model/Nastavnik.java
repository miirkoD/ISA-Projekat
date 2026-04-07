package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Nastavnik {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Lob
	private String biografija;
	
	@OneToMany(mappedBy = "nastavnik")
	private List<Dodela> dodele = new ArrayList<Dodela>();
	 
	@OneToMany(mappedBy = "nastavnik")
	private List<Zvanje> zvanja = new ArrayList<Zvanje>();
	
	@OneToMany(mappedBy = "nastavnik")
	private List<AdministrativnoAngazovanje> administrativnoAngazovanje= new ArrayList<AdministrativnoAngazovanje>();
	  
	@OneToMany(mappedBy = "nastavnik")
	private List<Angazovanje> angazovanja = new ArrayList<Angazovanje>();

	public Nastavnik() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Nastavnik(Long id, String biografija, List<Dodela> dodele, List<Zvanje> zvanja,
			List<AdministrativnoAngazovanje> administrativnoAngazovanje, List<Angazovanje> angazovanja) {
		super();
		this.id = id;
		this.biografija = biografija;
		this.dodele = dodele;
		this.zvanja = zvanja;
		this.administrativnoAngazovanje = administrativnoAngazovanje;
		this.angazovanja = angazovanja;
	}

	public Nastavnik(Long id, String biografija) {
		super();
		this.id = id;
		this.biografija = biografija;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBiografija() {
		return biografija;
	}

	public void setBiografija(String biografija) {
		this.biografija = biografija;
	}

	public List<Dodela> getDodele() {
		return dodele;
	}

	public void setDodele(List<Dodela> dodele) {
		this.dodele = dodele;
	}

	public List<Zvanje> getZvanja() {
		return zvanja;
	}

	public void setZvanja(List<Zvanje> zvanja) {
		this.zvanja = zvanja;
	}

	public List<AdministrativnoAngazovanje> getAdministrativnoAngazovanje() {
		return administrativnoAngazovanje;
	}

	public void setAdministrativnoAngazovanje(List<AdministrativnoAngazovanje> administrativnoAngazovanje) {
		this.administrativnoAngazovanje = administrativnoAngazovanje;
	}

	public List<Angazovanje> getAngazovanja() {
		return angazovanja;
	}

	public void setAngazovanja(List<Angazovanje> angazovanja) {
		this.angazovanja = angazovanja;
	}
   
}
