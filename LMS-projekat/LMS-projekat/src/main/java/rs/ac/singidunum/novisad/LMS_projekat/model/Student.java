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
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "student")
    private List<Dodela> dodele = new ArrayList<Dodela>();
	
	@OneToMany(mappedBy = "student")
	private List<StudentNaStudijskomProgramu> studentiNaStudijskimProgramima = new ArrayList<StudentNaStudijskomProgramu>();
	
	@ManyToOne(optional = false)
	private Adresa adresa;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Long id, List<Dodela> dodele, List<StudentNaStudijskomProgramu> studentiNaStudijskimProgramima,
			Adresa adresa) {
		super();
		this.id = id;
		this.dodele = dodele;
		this.studentiNaStudijskimProgramima = studentiNaStudijskimProgramima;
		this.adresa = adresa;
	}

	public Student(Long id, Adresa adresa) {
		super();
		this.id = id;
		this.adresa = adresa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Dodela> getDodele() {
		return dodele;
	}

	public void setDodele(List<Dodela> dodele) {
		this.dodele = dodele;
	}

	public List<StudentNaStudijskomProgramu> getStudentiNaStudijskimProgramima() {
		return studentiNaStudijskimProgramima;
	}

	public void setStudentiNaStudijskimProgramima(List<StudentNaStudijskomProgramu> studentiNaStudijskimProgramima) {
		this.studentiNaStudijskimProgramima = studentiNaStudijskimProgramima;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	
	
}
