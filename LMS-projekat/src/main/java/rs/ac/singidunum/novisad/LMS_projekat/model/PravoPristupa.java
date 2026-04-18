package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PravoPristupa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDateTime datumKreiranja;
	
	@Column
	private LocalDateTime datumBrisanja;
	
	@ManyToOne
	private RegistrovanKorisnik korisnik;
	
	@ManyToOne
	private Datoteka datoteka;

	public PravoPristupa() {
		super();
	}

	public PravoPristupa(Long id, LocalDateTime datumKreiranja, LocalDateTime datumBrisanja,
			RegistrovanKorisnik korisnik, Datoteka datoteka) {
		super();
		this.id = id;
		this.datumKreiranja = datumKreiranja;
		this.datumBrisanja = datumBrisanja;
		this.korisnik = korisnik;
		this.datoteka = datoteka;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDatumKreiranja() {
		return datumKreiranja;
	}

	public void setDatumKreiranja(LocalDateTime datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}

	public LocalDateTime getDatumBrisanja() {
		return datumBrisanja;
	}

	public void setDatumBrisanja(LocalDateTime datumBrisanja) {
		this.datumBrisanja = datumBrisanja;
	}

	public RegistrovanKorisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(RegistrovanKorisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Datoteka getDatoteka() {
		return datoteka;
	}

	public void setDatoteka(Datoteka datoteka) {
		this.datoteka = datoteka;
	}
	
	

}
