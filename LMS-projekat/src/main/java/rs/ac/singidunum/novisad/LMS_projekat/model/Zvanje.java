package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Zvanje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private LocalDateTime datumIzbora;
	
	@Column
	private LocalDateTime datumPrestanka;
	
	@ManyToOne(optional=false)
	private Nastavnik nastavnik;
	
	@ManyToOne(optional=false)
	private TipZvanja tipZvanja;
	
	@ManyToOne(optional=false)
	private NaucnaOblast naucnaOblast;

	public Zvanje() {
		super();
	}

	public Zvanje(Long id, LocalDateTime datumIzbora, LocalDateTime datumPrestanka, Nastavnik nastavnik,
			TipZvanja tipZvanja, NaucnaOblast naucnaOblast) {
		super();
		this.id = id;
		this.datumIzbora = datumIzbora;
		this.datumPrestanka = datumPrestanka;
		this.nastavnik = nastavnik;
		this.tipZvanja = tipZvanja;
		this.naucnaOblast = naucnaOblast;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDatumIzbora() {
		return datumIzbora;
	}

	public void setDatumIzbora(LocalDateTime datumIzbora) {
		this.datumIzbora = datumIzbora;
	}

	public LocalDateTime getDatumPrestanka() {
		return datumPrestanka;
	}

	public void setDatumPrestanka(LocalDateTime datumPrestanka) {
		this.datumPrestanka = datumPrestanka;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public TipZvanja getTipZvanja() {
		return tipZvanja;
	}

	public void setTipZvanja(TipZvanja tipZvanja) {
		this.tipZvanja = tipZvanja;
	}

	public NaucnaOblast getNaucnaOblast() {
		return naucnaOblast;
	}

	public void setNaucnaOblast(NaucnaOblast naucnaOblast) {
		this.naucnaOblast = naucnaOblast;
	}
	
	
	
}
