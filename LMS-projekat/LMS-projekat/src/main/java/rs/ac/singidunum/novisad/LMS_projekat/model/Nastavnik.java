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
public class Nastavnik {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String biografija;
	
	 @OneToMany(mappedBy = "nastavnik")
	 private List<Dodela> dodele = new ArrayList<Dodela>();
	 
	 @OneToMany(mappedBy = "nastavnik")
	 private List<Zvanje> zvanja = new ArrayList<Zvanje>();
	 
	 
	public Nastavnik() {
		super();
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


   
}
