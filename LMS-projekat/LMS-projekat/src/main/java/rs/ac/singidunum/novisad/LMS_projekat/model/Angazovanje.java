package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.sql.Date;
import java.time.LocalDateTime;

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
	private LocalDateTime pocetak;
	
	@Column(nullable = true)
	private LocalDateTime kraj;
	
	@ManyToOne(optional = false)
	private TipAngazovanja tipAngazovanja;
	
	@ManyToOne(optional = false)
	private Nastavnik nastavnik;
	
	@ManyToOne(optional = false)
	private TerminNastave terminNastave;
	
	@ManyToOne(optional=false)
	private RealizacijaPredmeta realizacijaPredmeta;

	public Angazovanje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Angazovanje(Long id, LocalDateTime pocetak, LocalDateTime kraj, TipAngazovanja tipAngazovanja,
			Nastavnik nastavnik, TerminNastave terminNastave, RealizacijaPredmeta realizacijaPredmeta) {
		super();
		this.id = id;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.tipAngazovanja = tipAngazovanja;
		this.nastavnik = nastavnik;
		this.terminNastave = terminNastave;
		this.realizacijaPredmeta = realizacijaPredmeta;
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

	public TipAngazovanja getTipAngazovanja() {
		return tipAngazovanja;
	}

	public void setTipAngazovanja(TipAngazovanja tipAngazovanja) {
		this.tipAngazovanja = tipAngazovanja;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public TerminNastave getTerminNastave() {
		return terminNastave;
	}

	public void setTerminNastave(TerminNastave terminNastave) {
		this.terminNastave = terminNastave;
	}

	public RealizacijaPredmeta getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmeta realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}
	
}
