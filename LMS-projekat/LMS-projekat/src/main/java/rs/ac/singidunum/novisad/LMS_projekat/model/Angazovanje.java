package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Angazovanje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Date pocetak;
	

	@Column(nullable = false)
	private Date kraj;
	
	@ManyToOne(optional = false)
	private TipAngazovanja tipAngazovanja;
	
	@ManyToOne(optional = false)
	private Nastavnik nastavnik;
	
	@ManyToOne(optional = false)
	private TerminNastave terminNastave;
}
