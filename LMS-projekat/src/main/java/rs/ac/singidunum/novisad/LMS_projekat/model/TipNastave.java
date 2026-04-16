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
public class TipNastave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@OneToMany(mappedBy = "tipNastave")
	private List<TerminNastave> terminiNastave = new ArrayList<TerminNastave>();

	public TipNastave() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipNastave(Long id, String naziv, List<TerminNastave> terminiNastave) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.terminiNastave = terminiNastave;
	}

	public TipNastave(Long id, String naziv) {
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

	public List<TerminNastave> getTerminiNastave() {
		return terminiNastave;
	}

	public void setTerminiNastave(List<TerminNastave> terminiNastave) {
		this.terminiNastave = terminiNastave;
	}

}
