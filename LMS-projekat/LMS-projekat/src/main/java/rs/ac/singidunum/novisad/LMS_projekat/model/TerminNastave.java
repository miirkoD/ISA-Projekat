package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class TerminNastave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDateTime pocetak;
	
	@Column()
	private LocalDateTime kraj;
	
	@ManyToOne(optional = false)
	private TipNastave tipNastave;
	
	@ManyToOne(optional = false)
	private NastavniMaterijal nastavniMaterijal;
	
	@ManyToOne(optional=false)
	private RealizacijaPredmeta realizacijaPredmeta;
	
	@OneToMany(mappedBy = "terminNastave")
	private List<Angazovanje> angazovanja = new ArrayList<Angazovanje>();

	public TerminNastave() {
		super();
	}

	public TerminNastave(Long id, LocalDateTime pocetak, LocalDateTime kraj, TipNastave tipNastave,
			NastavniMaterijal nastavniMaterijal, RealizacijaPredmeta realizacijaPredmeta,
			List<Angazovanje> angazovanja) {
		super();
		this.id = id;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.tipNastave = tipNastave;
		this.nastavniMaterijal = nastavniMaterijal;
		this.realizacijaPredmeta = realizacijaPredmeta;
		this.angazovanja = angazovanja;
	}

	public TerminNastave(Long id, LocalDateTime pocetak, LocalDateTime kraj, TipNastave tipNastave,
			NastavniMaterijal nastavniMaterijal, RealizacijaPredmeta realizacijaPredmeta) {
		super();
		this.id = id;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.tipNastave = tipNastave;
		this.nastavniMaterijal = nastavniMaterijal;
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

	public TipNastave getTipNastave() {
		return tipNastave;
	}

	public void setTipNastave(TipNastave tipNastave) {
		this.tipNastave = tipNastave;
	}

	public NastavniMaterijal getNastavniMaterijal() {
		return nastavniMaterijal;
	}

	public void setNastavniMaterijal(NastavniMaterijal nastavniMaterijal) {
		this.nastavniMaterijal = nastavniMaterijal;
	}

	public RealizacijaPredmeta getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmeta realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public List<Angazovanje> getAngazovanja() {
		return angazovanja;
	}

	public void setAngazovanja(List<Angazovanje> angazovanja) {
		this.angazovanja = angazovanja;
	}
	
}
