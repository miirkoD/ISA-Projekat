package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Dodela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private RegistrovanKorisnik korisnik;
    
    @ManyToOne
    private RegistrovanKorisnik dodelio;
    
    @Column
    private LocalDate pocetak;

    @Column
    private LocalDate kraj;
    
    @ManyToOne
    private Student student;

    @ManyToOne
    private Nastavnik nastavnik;

    @ManyToOne
    private Administrator administrator;

    @ManyToOne
    private AdministrativniSluzbenik administrativniSluzbenik;
    
	public Dodela() {
		super();
	}

	public Dodela(Long id, LocalDate pocetak, LocalDate kraj) {
		super();
		this.id = id;
		this.pocetak = pocetak;
		this.kraj = kraj;
	}
	
	

	public Dodela(Long id, RegistrovanKorisnik korisnik, RegistrovanKorisnik dodelio, LocalDate pocetak, LocalDate kraj,
			Student student, Nastavnik nastavnik, Administrator administrator,
			AdministrativniSluzbenik administrativniSluzbenik) {
		super();
		this.id = id;
		this.korisnik = korisnik;
		this.dodelio = dodelio;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.student = student;
		this.nastavnik = nastavnik;
		this.administrator = administrator;
		this.administrativniSluzbenik = administrativniSluzbenik;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RegistrovanKorisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(RegistrovanKorisnik korisnik) {
		this.korisnik = korisnik;
	}

	public RegistrovanKorisnik getDodelio() {
		return dodelio;
	}

	public void setDodelio(RegistrovanKorisnik dodelio) {
		this.dodelio = dodelio;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public AdministrativniSluzbenik getAdministrativniSluzbenik() {
		return administrativniSluzbenik;
	}

	public void setAdministrativniSluzbenik(AdministrativniSluzbenik administrativniSluzbenik) {
		this.administrativniSluzbenik = administrativniSluzbenik;
	}
    
    
    
}
