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
public class TipAngazovanja {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@OneToMany(mappedBy = "tipAngazovanja")
	private List<Angazovanje> angazovanja = new ArrayList<Angazovanje>();

	public TipAngazovanja() {
		super();
	}

	public TipAngazovanja(Long id, String naziv, List<Angazovanje> angazovanja) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.angazovanja = angazovanja;
	}

	public TipAngazovanja(Long id, String naziv) {
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

	public List<Angazovanje> getAngazovanja() {
		return angazovanja;
	}

	public void setAngazovanja(List<Angazovanje> angazovanja) {
		this.angazovanja = angazovanja;
	}

}
