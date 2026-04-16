package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.time.LocalDate;

public class DodelaDTO {

    private Long id;
    private LocalDate pocetak;
    private LocalDate kraj;
    private RegistrovanKorisnikDTO korisnik;
    private RegistrovanKorisnikDTO dodelio;
    private StudentDTO student;
    private NastavnikDTO nastavnik;
    private AdministratorDTO administrator;
    private AdministrativniSluzbenikDTO administrativniSluzbenik;

    public DodelaDTO() {}

 
    public DodelaDTO(Long id, LocalDate pocetak, LocalDate kraj) {
        this.id = id;
        this.pocetak = pocetak;
        this.kraj = kraj;
    }

    public DodelaDTO(Long id, LocalDate pocetak, LocalDate kraj, RegistrovanKorisnikDTO korisnik, RegistrovanKorisnikDTO dodelio, StudentDTO student, NastavnikDTO nastavnik, AdministratorDTO administrator, AdministrativniSluzbenikDTO administrativniSluzbenik) {
        this.id = id;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.korisnik = korisnik;
        this.dodelio = dodelio;
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


	public RegistrovanKorisnikDTO getKorisnik() {
		return korisnik;
	}


	public void setKorisnik(RegistrovanKorisnikDTO korisnik) {
		this.korisnik = korisnik;
	}


	public RegistrovanKorisnikDTO getDodelio() {
		return dodelio;
	}


	public void setDodelio(RegistrovanKorisnikDTO dodelio) {
		this.dodelio = dodelio;
	}


	public StudentDTO getStudent() {
		return student;
	}


	public void setStudent(StudentDTO student) {
		this.student = student;
	}


	public NastavnikDTO getNastavnik() {
		return nastavnik;
	}


	public void setNastavnik(NastavnikDTO nastavnik) {
		this.nastavnik = nastavnik;
	}


	public AdministratorDTO getAdministrator() {
		return administrator;
	}


	public void setAdministrator(AdministratorDTO administrator) {
		this.administrator = administrator;
	}


	public AdministrativniSluzbenikDTO getAdministrativniSluzbenik() {
		return administrativniSluzbenik;
	}


	public void setAdministrativniSluzbenik(AdministrativniSluzbenikDTO administrativniSluzbenik) {
		this.administrativniSluzbenik = administrativniSluzbenik;
	}

    

}
