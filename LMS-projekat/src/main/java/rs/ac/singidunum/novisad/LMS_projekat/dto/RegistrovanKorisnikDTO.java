package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.util.ArrayList;
import java.util.List;

public class RegistrovanKorisnikDTO {

    private Long id;
    private String ime;
    private String prezime;
    private String jmbg;
    private String korisnickoIme;
    private String lozinka;
    private List<DodelaDTO> dodeljeneUloge = new ArrayList<>();
    private List<DodelaDTO> izvrseneDodale = new ArrayList<>();
    private List<PravoPristupaDTO> prava = new ArrayList<>();

    public RegistrovanKorisnikDTO() {}


    public RegistrovanKorisnikDTO(Long id, String ime, String prezime, String jmbg, String korisnickoIme, String lozinka) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public RegistrovanKorisnikDTO(Long id, String ime, String prezime, String jmbg, String korisnickoIme, String lozinka, List<DodelaDTO> dodeljeneUloge, List<DodelaDTO> izvrseneDodale, List<PravoPristupaDTO> prava) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.dodeljeneUloge = dodeljeneUloge;
        this.izvrseneDodale = izvrseneDodale;
        this.prava = prava;
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}


	public String getJmbg() {
		return jmbg;
	}


	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}


	public String getKorisnickoIme() {
		return korisnickoIme;
	}


	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}


	public String getLozinka() {
		return lozinka;
	}


	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}


	public List<DodelaDTO> getDodeljeneUloge() {
		return dodeljeneUloge;
	}


	public void setDodeljeneUloge(List<DodelaDTO> dodeljeneUloge) {
		this.dodeljeneUloge = dodeljeneUloge;
	}


	public List<DodelaDTO> getIzvrseneDodale() {
		return izvrseneDodale;
	}


	public void setIzvrseneDodale(List<DodelaDTO> izvrseneDodale) {
		this.izvrseneDodale = izvrseneDodale;
	}


	public List<PravoPristupaDTO> getPrava() {
		return prava;
	}


	public void setPrava(List<PravoPristupaDTO> prava) {
		this.prava = prava;
	}

 

}
