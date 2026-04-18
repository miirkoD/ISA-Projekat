package rs.ac.singidunum.novisad.LMS_projekat.model;


import java.time.LocalDateTime;
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
	private LocalDateTime pocetak;
	
	@Column()
	private LocalDateTime kraj;
	
	@Column()
	private Integer bodovi;
	
	@ManyToOne(optional = false)
	private TipEvaluacijeZnanja tipEvaluacijeZnanja;
	
	@OneToMany(mappedBy = "evaluacijaZnanja")
	private List<Polaganje> polaganja = new ArrayList<Polaganje>();
	
	@ManyToOne(optional = false)
	private InstrumentEvaluacijeZnanja instrumentEvaluacijeZnanja;
	
	@ManyToOne(optional=false)
	private RealizacijaPredmeta realizacijaPredmeta;

	public EvaluacijaZnanja() {
		super();
	}

	public EvaluacijaZnanja(Long id, LocalDateTime pocetak, LocalDateTime kraj, Integer bodovi,
			TipEvaluacijeZnanja tipEvaluacijeZnanja, List<Polaganje> polaganja,
			InstrumentEvaluacijeZnanja instrumentEvaluacijeZnanja, RealizacijaPredmeta realizacijaPredmeta) {
		super();
		this.id = id;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.bodovi = bodovi;
		this.tipEvaluacijeZnanja = tipEvaluacijeZnanja;
		this.polaganja = polaganja;
		this.instrumentEvaluacijeZnanja = instrumentEvaluacijeZnanja;
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public EvaluacijaZnanja(Long id, LocalDateTime pocetak, LocalDateTime kraj, Integer bodovi,
			TipEvaluacijeZnanja tipEvaluacijeZnanja, InstrumentEvaluacijeZnanja instrumentEvaluacijeZnanja,
			RealizacijaPredmeta realizacijaPredmeta) {
		super();
		this.id = id;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.bodovi = bodovi;
		this.tipEvaluacijeZnanja = tipEvaluacijeZnanja;
		this.instrumentEvaluacijeZnanja = instrumentEvaluacijeZnanja;
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

	public Integer getBodovi() {
		return bodovi;
	}

	public void setBodovi(Integer bodovi) {
		this.bodovi = bodovi;
	}

	public TipEvaluacijeZnanja getTipEvaluacijeZnanja() {
		return tipEvaluacijeZnanja;
	}

	public void setTipEvaluacijeZnanja(TipEvaluacijeZnanja tipEvaluacijeZnanja) {
		this.tipEvaluacijeZnanja = tipEvaluacijeZnanja;
	}

	public List<Polaganje> getPolaganja() {
		return polaganja;
	}

	public void setPolaganja(List<Polaganje> polaganja) {
		this.polaganja = polaganja;
	}

	public InstrumentEvaluacijeZnanja getInstrumentEvaluacijeZnanja() {
		return instrumentEvaluacijeZnanja;
	}

	public void setInstrumentEvaluacijeZnanja(InstrumentEvaluacijeZnanja instrumentEvaluacijeZnanja) {
		this.instrumentEvaluacijeZnanja = instrumentEvaluacijeZnanja;
	}

	public RealizacijaPredmeta getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmeta realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}
	
}
