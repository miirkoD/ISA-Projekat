package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.util.ArrayList;
import java.util.List;

public class TipAngazovanjaDTO {

    private Long id;
    private String naziv;
    private List<AngazovanjeDTO> angazovanja = new ArrayList<>();

    public TipAngazovanjaDTO() {}

    public TipAngazovanjaDTO(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public TipAngazovanjaDTO(Long id, String naziv, List<AngazovanjeDTO> angazovanja) {
        this.id = id;
        this.naziv = naziv;
        this.angazovanja = angazovanja;
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

	public List<AngazovanjeDTO> getAngazovanja() {
		return angazovanja;
	}

	public void setAngazovanja(List<AngazovanjeDTO> angazovanja) {
		this.angazovanja = angazovanja;
	}
    

}