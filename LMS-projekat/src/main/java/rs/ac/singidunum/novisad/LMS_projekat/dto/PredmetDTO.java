package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.util.ArrayList;
import java.util.List;

public class PredmetDTO {

    private Long id;
    private String naziv;
    private int espb;
    private boolean obavezan;
    private int brojPredavanja;
    private int brojVezbi;
    private int drugiObliciNastave;
    private int istrazivackiRad;
    private int brojOstalihCasova;
    private GodinaStudijaDTO godinaStudija;
    private List<SadrzajPredmetaDTO> sadrzajPredmeta = new ArrayList<>();
    private List<IshodDTO> ishod = new ArrayList<>();
    private List<ObrazovniCiljDTO> obrazovniCilj = new ArrayList<>();
    private List<RealizacijaPredmetaDTO> realizacijaPredmeta = new ArrayList<>();

    public PredmetDTO() {}

    public PredmetDTO(Long id, String naziv, int espb, boolean obavezan, int brojPredavanja, int brojVezbi, int drugiObliciNastave, int istrazivackiRad, int brojOstalihCasova) {
        this.id = id;
        this.naziv = naziv;
        this.espb = espb;
        this.obavezan = obavezan;
        this.brojPredavanja = brojPredavanja;
        this.brojVezbi = brojVezbi;
        this.drugiObliciNastave = drugiObliciNastave;
        this.istrazivackiRad = istrazivackiRad;
        this.brojOstalihCasova = brojOstalihCasova;
    }
    
  public PredmetDTO(Long id, String naziv, int espb, boolean obavezan, int brojPredavanja, int brojVezbi, int drugiObliciNastave, int istrazivackiRad, int brojOstalihCasova, GodinaStudijaDTO godinaStudija) {
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

  public PredmetDTO(Long id, String naziv, int espb, boolean obavezan, int brojPredavanja, int brojVezbi, int drugiObliciNastave, int istrazivackiRad, int brojOstalihCasova, GodinaStudijaDTO godinaStudija, List<SadrzajPredmetaDTO> sadrzajPredmeta, List<IshodDTO> ishod, List<ObrazovniCiljDTO> obrazovniCilj, List<RealizacijaPredmetaDTO> realizacijaPredmeta) {
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

	public List<SadrzajPredmetaDTO> getSadrzajPredmeta() {
		return sadrzajPredmeta;
	}

	public void setSadrzajPredmeta(List<SadrzajPredmetaDTO> sadrzajPredmeta) {
		this.sadrzajPredmeta = sadrzajPredmeta;
	}

	public List<IshodDTO> getIshod() {
		return ishod;
	}

	public void setIshod(List<IshodDTO> ishod) {
		this.ishod = ishod;
	}

	public List<ObrazovniCiljDTO> getObrazovniCilj() {
		return obrazovniCilj;
	}

	public void setObrazovniCilj(List<ObrazovniCiljDTO> obrazovniCilj) {
		this.obrazovniCilj = obrazovniCilj;
	}

	public List<RealizacijaPredmetaDTO> getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(List<RealizacijaPredmetaDTO> realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public GodinaStudijaDTO getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudijaDTO godinaStudija) {
		this.godinaStudija = godinaStudija;
	}


}