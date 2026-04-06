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
	
	@ManyToOne(optional = false)
	private Nastavnik nastavnik;
	
	@ManyToOne(optional = false)
	private StudijskiProgram studijskiProgram;
	
	@ManyToOne(optional = false)
	private Fakultet fakultet;

	public AdministrativnoAngazovanje() {
		super();
	}

	public AdministrativnoAngazovanje(Long id, LocalDateTime pocetak, LocalDateTime kraj, Nastavnik nastavnik,
			StudijskiProgram studijskiProgram, Fakultet fakultet) {
		super();
		this.id = id;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.nastavnik = nastavnik;
		this.studijskiProgram = studijskiProgram;
		this.fakultet = fakultet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getPocetak() {
		return pocetak;
	}

	public void setPocetak(LocalDateTime pocetak) {
		this.pocetak = pocetak;
	}

	public LocalDateTime getKraj() {
		return kraj;
	}

	public void setKraj(LocalDateTime kraj) {
		this.kraj = kraj;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public StudijskiProgram getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}

	public Fakultet getFakultet() {
		return fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}
	
}
