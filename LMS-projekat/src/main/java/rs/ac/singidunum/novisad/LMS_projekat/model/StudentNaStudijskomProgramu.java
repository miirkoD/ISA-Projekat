package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class StudentNaStudijskomProgramu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String brojIndeksa;
	
	@ManyToOne(optional = false)
	private Student student;
	
	@OneToMany(mappedBy = "studentiNaStudijskimProgramima")
	private List<Pohadjanje> pohadjanja = new ArrayList<Pohadjanje>();
	
	@OneToMany(mappedBy = "studentiNaStudijskimProgramima", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Polaganje> polaganja = new ArrayList<Polaganje>();
	
	@OneToMany(mappedBy = "studentNaStudijskomProgramu")
	private List<Upis>upisi=new ArrayList<Upis>();

	public StudentNaStudijskomProgramu() {
		super();
	}

	public StudentNaStudijskomProgramu(Long id, String brojIndeksa, Student student, List<Pohadjanje> pohadjanja,
			List<Polaganje> polaganja, List<Upis> upisi) {
		super();
		this.id = id;
		this.brojIndeksa = brojIndeksa;
		this.student = student;
		this.pohadjanja = pohadjanja;
		this.polaganja = polaganja;
		this.upisi = upisi;
	}

	public StudentNaStudijskomProgramu(Long id, String brojIndeksa, Student student) {
		super();
		this.id = id;
		this.brojIndeksa = brojIndeksa;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Pohadjanje> getPohadjanja() {
		return pohadjanja;
	}

	public void setPohadjanja(List<Pohadjanje> pohadjanja) {
		this.pohadjanja = pohadjanja;
	}

	public List<Polaganje> getPolaganja() {
		return polaganja;
	}

	public void setPolaganja(List<Polaganje> polaganja) {
		this.polaganja = polaganja;
	}

	public List<Upis> getUpisi() {
		return upisi;
	}

	public void setUpisi(List<Upis> upisi) {
		this.upisi = upisi;
	}
	
}
