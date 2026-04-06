package rs.ac.singidunum.novisad.LMS_projekat.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Pohadjanje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column()
	private Integer konacnaOcena;
	
	@ManyToOne(optional = false)
	private StudentNaStudijskomProgramu studentiNaStudijskimProgramima;
	
	@ManyToOne(optional=false)
	private RealizacijaPredmeta realizacijaPredmeta;

	public Pohadjanje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pohadjanje(Long id, Integer konacnaOcena, StudentNaStudijskomProgramu studentiNaStudijskimProgramima,
			RealizacijaPredmeta realizacijaPredmeta) {
		super();
		this.id = id;
		this.konacnaOcena = konacnaOcena;
		this.studentiNaStudijskimProgramima = studentiNaStudijskimProgramima;
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getKonacnaOcena() {
		return konacnaOcena;
	}

	public void setKonacnaOcena(Integer konacnaOcena) {
		this.konacnaOcena = konacnaOcena;
	}

	public StudentNaStudijskomProgramu getStudentiNaStudijskimProgramima() {
		return studentiNaStudijskimProgramima;
	}

	public void setStudentiNaStudijskimProgramima(StudentNaStudijskomProgramu studentiNaStudijskimProgramima) {
		this.studentiNaStudijskimProgramima = studentiNaStudijskimProgramima;
	}

	public RealizacijaPredmeta getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmeta realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}
	
}
