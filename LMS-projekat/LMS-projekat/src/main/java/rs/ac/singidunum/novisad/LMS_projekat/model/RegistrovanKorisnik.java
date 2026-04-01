package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class RegistrovanKorisnik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String ime;
	
	@Column(nullable = false)
	private String prezime;
	
	@Column
	private String jmbg;
	
	@Column
	private String korisnickoIme;
	
	@Column
	private String lozinka;
	
    @OneToMany(mappedBy = "korisnik", cascade = CascadeType.ALL)
    private List<Dodela> dodeljeneUloge = new ArrayList<Dodela>();

    @OneToMany(mappedBy = "dodelio")
    private List<Dodela> izvrseneDodale = new ArrayList<Dodela>();
    
    @OneToMany(mappedBy = "korisnik")
    private List<PravoPristupa> prava = new ArrayList<PravoPristupa>();
	
	public RegistrovanKorisnik() {
		super();
	}

	public RegistrovanKorisnik(Long id, String ime, String prezime, String jmbg, String korisnickoIme, String lozinka) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
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

	public List<Dodela> getDodeljeneUloge() {
		return dodeljeneUloge;
	}

	public void setDodeljeneUloge(List<Dodela> dodeljeneUloge) {
		this.dodeljeneUloge = dodeljeneUloge;
	}

	public List<Dodela> getIzvrseneDodale() {
		return izvrseneDodale;
	}

	public void setIzvrseneDodale(List<Dodela> izvrseneDodale) {
		this.izvrseneDodale = izvrseneDodale;
	}


	

}
