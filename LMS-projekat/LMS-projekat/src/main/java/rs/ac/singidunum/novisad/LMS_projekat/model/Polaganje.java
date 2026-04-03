package rs.ac.singidunum.novisad.LMS_projekat.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Polaganje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private int bodovi;
	
	@Column(nullable = false)
	private String napomena;
	
	@ManyToOne(optional = false)
	private StudentNaStudijskomProgramu studentiNaStudijskimProgramima;
	
	@ManyToOne(optional = false)
	private EvaluacijaZnanja evaluacijaZnanja;
}
