package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class SkolskaGodina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private LocalDate pocetak;
	
	@Column(nullable = false)
	private LocalDate kraj;
	
	@ManyToOne(optional=false)
	private GodinaStudija godinaStudija;

	public SkolskaGodina() {
		super();
	}
}
