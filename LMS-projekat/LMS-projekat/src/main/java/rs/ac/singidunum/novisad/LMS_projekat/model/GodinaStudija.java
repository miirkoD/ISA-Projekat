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
public class GodinaStudija {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String naziv;
	
	@ManyToOne(optional=false)
	private StudijskiProgram studijskiProgram;
	
	@OneToMany(mappedBy = "godinaStudija")
	private List<SkolskaGodina> skolskaGodina = new ArrayList<SkolskaGodina>();
	
	@OneToMany(mappedBy = "godinaStudija")
	private List<Predmet>predmeti=new ArrayList<Predmet>();
	
	@OneToMany(mappedBy = "godinaStudija")
	private List<Upis> upisi= new ArrayList<Upis>();

	public GodinaStudija() {
		super();
	}

	public GodinaStudija(Long id, String naziv, StudijskiProgram studijskiProgram, List<SkolskaGodina> skolskaGodina,
			List<Predmet> predmeti, List<Upis> upisi) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.studijskiProgram = studijskiProgram;
		this.skolskaGodina = skolskaGodina;
		this.predmeti = predmeti;
		this.upisi = upisi;
	}

	public GodinaStudija(Long id, String naziv, StudijskiProgram studijskiProgram) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.studijskiProgram = studijskiProgram;
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

	public StudijskiProgram getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}

	public List<SkolskaGodina> getSkolskaGodina() {
		return skolskaGodina;
	}

	public void setSkolskaGodina(List<SkolskaGodina> skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public List<Upis> getUpisi() {
		return upisi;
	}

	public void setUpisi(List<Upis> upisi) {
		this.upisi = upisi;
	}
	
}
