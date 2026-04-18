package rs.ac.singidunum.novisad.LMS_projekat.model;


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
public class Predmet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@Column(nullable = false)
	private int espb;
	
	@Column(nullable = false)
	private boolean obavezan;
	
	@Column(nullable = false)
	private int brojPredavanja;
	
	@Column(nullable = false)
	private int brojVezbi;
	
	@Column()
	private int drugiObliciNastave;
	
	@Column()
	private int istrazivackiRad;
	
	@Column()
	private int brojOstalihCasova;
	
	@ManyToOne(optional = false)
	private GodinaStudija godinaStudija;
	
	@OneToMany(mappedBy = "predmet")
	private List<SadrzajPredmeta> sadrzajPredmeta=new ArrayList<SadrzajPredmeta>();
	
	@OneToMany(mappedBy = "predmet")
	private List<Ishod> ishod=new ArrayList<Ishod>();
	
	@OneToMany(mappedBy = "predmet")
	private List<ObrazovniCilj> obrazovniCilj=new ArrayList<ObrazovniCilj>();
	
	@OneToMany(mappedBy = "predmet")
	private List<RealizacijaPredmeta> realizacijaPredmeta=new ArrayList<RealizacijaPredmeta>();

	public Predmet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Predmet(Long id, String naziv, int espb, boolean obavezan, int brojPredavanja, int brojVezbi,
			int drugiObliciNastave, int istrazivackiRad, int brojOstalihCasova, GodinaStudija godinaStudija,
			List<SadrzajPredmeta> sadrzajPredmeta, List<Ishod> ishod, List<ObrazovniCilj> obrazovniCilj,
			List<RealizacijaPredmeta> realizacijaPredmeta) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.espb = espb;
		this.obavezan = obavezan;
		this.brojPredavanja = brojPredavanja;
		this.brojVezbi = brojVezbi;
		this.drugiObliciNastave = drugiObliciNastave;
		this.istrazivackiRad = istrazivackiRad;
		this.brojOstalihCasova = brojOstalihCasova;
		this.godinaStudija = godinaStudija;
		this.sadrzajPredmeta = sadrzajPredmeta;
		this.ishod = ishod;
		this.obrazovniCilj = obrazovniCilj;
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public Predmet(Long id, String naziv, int espb, boolean obavezan, int brojPredavanja, int brojVezbi,
			int drugiObliciNastave, int istrazivackiRad, int brojOstalihCasova, GodinaStudija godinaStudija) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.espb = espb;
		this.obavezan = obavezan;
		this.brojPredavanja = brojPredavanja;
		this.brojVezbi = brojVezbi;
		this.drugiObliciNastave = drugiObliciNastave;
		this.istrazivackiRad = istrazivackiRad;
		this.brojOstalihCasova = brojOstalihCasova;
		this.godinaStudija = godinaStudija;
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

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public boolean isObavezan() {
		return obavezan;
	}

	public void setObavezan(boolean obavezan) {
		this.obavezan = obavezan;
	}

	public int getBrojPredavanja() {
		return brojPredavanja;
	}

	public void setBrojPredavanja(int brojPredavanja) {
		this.brojPredavanja = brojPredavanja;
	}

	public int getBrojVezbi() {
		return brojVezbi;
	}

	public void setBrojVezbi(int brojVezbi) {
		this.brojVezbi = brojVezbi;
	}

	public int getDrugiObliciNastave() {
		return drugiObliciNastave;
	}

	public void setDrugiObliciNastave(int drugiObliciNastave) {
		this.drugiObliciNastave = drugiObliciNastave;
	}

	public int getIstrazivackiRad() {
		return istrazivackiRad;
	}

	public void setIstrazivackiRad(int istrazivackiRad) {
		this.istrazivackiRad = istrazivackiRad;
	}

	public int getBrojOstalihCasova() {
		return brojOstalihCasova;
	}

	public void setBrojOstalihCasova(int brojOstalihCasova) {
		this.brojOstalihCasova = brojOstalihCasova;
	}

	public GodinaStudija getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudija godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public List<SadrzajPredmeta> getSadrzajPredmeta() {
		return sadrzajPredmeta;
	}

	public void setSadrzajPredmeta(List<SadrzajPredmeta> sadrzajPredmeta) {
		this.sadrzajPredmeta = sadrzajPredmeta;
	}

	public List<Ishod> getIshod() {
		return ishod;
	}

	public void setIshod(List<Ishod> ishod) {
		this.ishod = ishod;
	}

	public List<ObrazovniCilj> getObrazovniCilj() {
		return obrazovniCilj;
	}

	public void setObrazovniCilj(List<ObrazovniCilj> obrazovniCilj) {
		this.obrazovniCilj = obrazovniCilj;
	}

	public List<RealizacijaPredmeta> getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(List<RealizacijaPredmeta> realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}
	
}
