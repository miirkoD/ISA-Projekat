package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UniverzitetDTO {

    private Long id;
    private String naziv;
    private LocalDate datumOsnivanja;
    private AdresaDTO adresa;
    private List<FakultetDTO> fakulteti = new ArrayList<>();

    public UniverzitetDTO() {}

    public UniverzitetDTO(Long id, String naziv, LocalDate datumOsnivanja) {
        this.id = id;
        this.naziv = naziv;
        this.datumOsnivanja = datumOsnivanja;
    }

    public UniverzitetDTO(Long id, String naziv, LocalDate datumOsnivanja, AdresaDTO adresa) {
        this.id = id;
        this.naziv = naziv;
        this.datumOsnivanja = datumOsnivanja;
        this.adresa = adresa;
    }

    public UniverzitetDTO(Long id, String naziv, LocalDate datumOsnivanja, AdresaDTO adresa, List<FakultetDTO> fakulteti) {
        this.id = id;
        this.naziv = naziv;
        this.datumOsnivanja = datumOsnivanja;
        this.adresa = adresa;
        this.fakulteti = fakulteti;
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

	public LocalDate getDatumOsnivanja() {
		return datumOsnivanja;
	}

	public void setDatumOsnivanja(LocalDate datumOsnivanja) {
		this.datumOsnivanja = datumOsnivanja;
	}

	public AdresaDTO getAdresa() {
		return adresa;
	}

	public void setAdresa(AdresaDTO adresa) {
		this.adresa = adresa;
	}

	public List<FakultetDTO> getFakulteti() {
		return fakulteti;
	}

	public void setFakulteti(List<FakultetDTO> fakulteti) {
		this.fakulteti = fakulteti;
	}

    
}
