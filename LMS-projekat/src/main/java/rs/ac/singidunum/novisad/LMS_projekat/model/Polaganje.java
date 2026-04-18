package rs.ac.singidunum.novisad.LMS_projekat.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Polaganje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private int bodovi;
	
	@Column(nullable = false)
	@Lob
	private String napomena;
	
	@ManyToOne(optional = false)
	private StudentNaStudijskomProgramu studentiNaStudijskimProgramima;
	
	@ManyToOne(optional = false)
	private EvaluacijaZnanja evaluacijaZnanja;

	public Polaganje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Polaganje(Long id, int bodovi, String napomena, StudentNaStudijskomProgramu studentiNaStudijskimProgramima,
			EvaluacijaZnanja evaluacijaZnanja) {
		super();
		this.id = id;
		this.bodovi = bodovi;
		this.napomena = napomena;
		this.studentiNaStudijskimProgramima = studentiNaStudijskimProgramima;
		this.evaluacijaZnanja = evaluacijaZnanja;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBodovi() {
		return bodovi;
	}

	public void setBodovi(int bodovi) {
		this.bodovi = bodovi;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public StudentNaStudijskomProgramu getStudentiNaStudijskimProgramima() {
		return studentiNaStudijskimProgramima;
	}

	public void setStudentiNaStudijskimProgramima(StudentNaStudijskomProgramu studentiNaStudijskimProgramima) {
		this.studentiNaStudijskimProgramima = studentiNaStudijskimProgramima;
	}

	public EvaluacijaZnanja getEvaluacijaZnanja() {
		return evaluacijaZnanja;
	}

	public void setEvaluacijaZnanja(EvaluacijaZnanja evaluacijaZnanja) {
		this.evaluacijaZnanja = evaluacijaZnanja;
	}
	
}
