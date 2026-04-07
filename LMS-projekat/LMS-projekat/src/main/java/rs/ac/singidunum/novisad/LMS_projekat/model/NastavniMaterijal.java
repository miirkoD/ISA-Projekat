package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class NastavniMaterijal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@Column(nullable = false)
	@Lob
	private String opis;
	
	@ManyToOne(optional = false)
	private TipNastavnogMaterijala tipNastavnogMaterijala;
	
	@ManyToOne(optional = false)
	private InstrumentEvaluacijeZnanja instrumentEvaluacijeZnanja;
	
	@OneToMany(mappedBy = "nastavniMaterijal", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Datoteka> datoteke = new ArrayList<Datoteka>();
	
	@OneToMany(mappedBy = "nastavniMaterijal")
	private List<TerminNastave> terminiNastave = new ArrayList<TerminNastave>();
	
	@ManyToOne(optional=false)
	private RealizacijaPredmeta realizacijaPredmeta;

	public NastavniMaterijal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NastavniMaterijal(Long id, String naziv, String opis, TipNastavnogMaterijala tipNastavnogMaterijala,
			InstrumentEvaluacijeZnanja instrumentEvaluacijeZnanja, List<Datoteka> datoteke,
			List<TerminNastave> terminiNastave, RealizacijaPredmeta realizacijaPredmeta) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.tipNastavnogMaterijala = tipNastavnogMaterijala;
		this.instrumentEvaluacijeZnanja = instrumentEvaluacijeZnanja;
		this.datoteke = datoteke;
		this.terminiNastave = terminiNastave;
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public NastavniMaterijal(Long id, String naziv, String opis, TipNastavnogMaterijala tipNastavnogMaterijala,
			InstrumentEvaluacijeZnanja instrumentEvaluacijeZnanja, RealizacijaPredmeta realizacijaPredmeta) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.tipNastavnogMaterijala = tipNastavnogMaterijala;
		this.instrumentEvaluacijeZnanja = instrumentEvaluacijeZnanja;
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public TipNastavnogMaterijala getTipNastavnogMaterijala() {
		return tipNastavnogMaterijala;
	}

	public void setTipNastavnogMaterijala(TipNastavnogMaterijala tipNastavnogMaterijala) {
		this.tipNastavnogMaterijala = tipNastavnogMaterijala;
	}

	public InstrumentEvaluacijeZnanja getInstrumentEvaluacijeZnanja() {
		return instrumentEvaluacijeZnanja;
	}

	public void setInstrumentEvaluacijeZnanja(InstrumentEvaluacijeZnanja instrumentEvaluacijeZnanja) {
		this.instrumentEvaluacijeZnanja = instrumentEvaluacijeZnanja;
	}

	public List<Datoteka> getDatoteke() {
		return datoteke;
	}

	public void setDatoteke(List<Datoteka> datoteke) {
		this.datoteke = datoteke;
	}

	public List<TerminNastave> getTerminiNastave() {
		return terminiNastave;
	}

	public void setTerminiNastave(List<TerminNastave> terminiNastave) {
		this.terminiNastave = terminiNastave;
	}

	public RealizacijaPredmeta getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmeta realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

}
