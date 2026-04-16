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
public class NaucnaOblast {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@OneToMany(mappedBy = "naucnaOblast")
	private List<Zvanje> zvanja = new ArrayList<Zvanje>();

	public NaucnaOblast() {
		super();
	}

	public NaucnaOblast(Long id, String naziv, List<Zvanje> zvanja) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.zvanja = zvanja;
	}

	public NaucnaOblast(Long id, String naziv) {
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

	public List<Zvanje> getZvanja() {
		return zvanja;
	}

	public void setZvanja(List<Zvanje> zvanja) {
		this.zvanja = zvanja;
	}
	
	
	
	

}
