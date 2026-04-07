package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.time.LocalDate;
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
public class SkolskaGodina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private LocalDate pocetak;
	
	@Column()
	private LocalDate kraj;
	
	@ManyToOne(optional=false)
	private GodinaStudija godinaStudija;
	
	@OneToMany(mappedBy = "skolskaGodina")
	private List<RealizacijaPredmeta> realizacijaPredmeta=new ArrayList<RealizacijaPredmeta>();
	
	@OneToMany(mappedBy = "skolskaGodina")
	private List<Upis>upisi=new ArrayList<Upis>();

	public SkolskaGodina() {
		super();
	}

	public SkolskaGodina(Long id, LocalDate pocetak, LocalDate kraj, GodinaStudija godinaStudija,
			List<RealizacijaPredmeta> realizacijaPredmeta, List<Upis> upisi) {
		super();
		this.id = id;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.godinaStudija = godinaStudija;
		this.realizacijaPredmeta = realizacijaPredmeta;
		this.upisi = upisi;
	}

	public SkolskaGodina(Long id, LocalDate pocetak, LocalDate kraj, GodinaStudija godinaStudija) {
		super();
		this.id = id;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.godinaStudija = godinaStudija;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getPocetak() {
		return pocetak;
	}

	public void setPocetak(LocalDate pocetak) {
		this.pocetak = pocetak;
	}

	public LocalDate getKraj() {
		return kraj;
	}

	public void setKraj(LocalDate kraj) {
		this.kraj = kraj;
	}

	public GodinaStudija getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudija godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public List<RealizacijaPredmeta> getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(List<RealizacijaPredmeta> realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public List<Upis> getUpisi() {
		return upisi;
	}

	public void setUpisi(List<Upis> upisi) {
		this.upisi = upisi;
	}
	
}
