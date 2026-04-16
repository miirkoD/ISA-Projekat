package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.time.LocalDateTime;

public class PravoPristupaDTO {

    private Long id;
    private LocalDateTime datumKreiranja;
    private LocalDateTime datumBrisanja;
    private RegistrovanKorisnikDTO korisnik;
    private DatotekaDTO datoteka;

    public PravoPristupaDTO() {}

    
    public PravoPristupaDTO(Long id, LocalDateTime datumKreiranja, LocalDateTime datumBrisanja) {
        this.id = id;
        this.datumKreiranja = datumKreiranja;
        this.datumBrisanja = datumBrisanja;
    }

    public PravoPristupaDTO(Long id, LocalDateTime datumKreiranja, LocalDateTime datumBrisanja, RegistrovanKorisnikDTO korisnik, DatotekaDTO datoteka) {
        this.id = id;
        this.datumKreiranja = datumKreiranja;
        this.datumBrisanja = datumBrisanja;
        this.korisnik = korisnik;
        this.datoteka = datoteka;
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDateTime getDatumKreiranja() {
		return datumKreiranja;
	}


	public void setDatumKreiranja(LocalDateTime datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}


	public LocalDateTime getDatumBrisanja() {
		return datumBrisanja;
	}


	public void setDatumBrisanja(LocalDateTime datumBrisanja) {
		this.datumBrisanja = datumBrisanja;
	}


	public RegistrovanKorisnikDTO getKorisnik() {
		return korisnik;
	}


	public void setKorisnik(RegistrovanKorisnikDTO korisnik) {
		this.korisnik = korisnik;
	}


	public DatotekaDTO getDatoteka() {
		return datoteka;
	}


	public void setDatoteka(DatotekaDTO datoteka) {
		this.datoteka = datoteka;
	}

    

}
