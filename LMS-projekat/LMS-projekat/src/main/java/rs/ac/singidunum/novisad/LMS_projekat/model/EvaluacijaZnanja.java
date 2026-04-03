package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.sql.Date;
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
public class EvaluacijaZnanja {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Date pocetak;
	
	@Column(nullable = false)
	private Date kraj;
	
	@Column(nullable = false)
	private int bodovi;
	
	@ManyToOne(optional = false)
	private Pohadjanje pohadjanje;
	
	@ManyToOne(optional = false)
	private TipEvaluacijeZnanja tipEvaluacijeZnanja;
	
	@OneToMany(mappedBy = "evaluacijaZnanja")
	private List<Polaganje> polaganja = new ArrayList<Polaganje>();
	
}
