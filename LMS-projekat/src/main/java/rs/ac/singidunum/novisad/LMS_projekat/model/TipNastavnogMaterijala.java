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
public class TipNastavnogMaterijala {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@OneToMany(mappedBy = "tipNastavnogMaterijala")
	private List<NastavniMaterijal> nastavniMaterijali = new ArrayList<NastavniMaterijal>();

	public TipNastavnogMaterijala() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipNastavnogMaterijala(Long id, String naziv, List<NastavniMaterijal> nastavniMaterijali) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.nastavniMaterijali = nastavniMaterijali;
	}

	public TipNastavnogMaterijala(Long id, String naziv) {
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
	
	
}
