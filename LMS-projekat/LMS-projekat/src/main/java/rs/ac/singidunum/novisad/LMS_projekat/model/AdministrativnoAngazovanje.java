package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class AdministrativnoAngazovanje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private LocalDateTime pocetak;
	
	@Column
	private LocalDateTime kraj;
	
	@ManyToOne
	private Nastavnik nastavnik;
	
	@ManyToOne
	private StudijskiProgram studijskiProgram;

	public AdministrativnoAngazovanje() {
		super();
	}
}
