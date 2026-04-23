package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.util.ArrayList;
import java.util.List;

public class StudijskiProgramDTO {

    private Long id;
    private String naziv;
    private FakultetDTO fakultet;
    private List<GodinaStudijaDTO> godineStudija = new ArrayList<>();
    private List<AdministrativnoAngazovanjeDTO> administrativnoAngazovanje = new ArrayList<>();

    public StudijskiProgramDTO() {}

    public StudijskiProgramDTO(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public StudijskiProgramDTO(Long id, String naziv, FakultetDTO fakultet) {
        this.id = id;
        this.naziv = naziv;
        this.fakultet = fakultet;
    }

    public StudijskiProgramDTO(Long id, String naziv, FakultetDTO fakultet, List<GodinaStudijaDTO> godineStudija, List<AdministrativnoAngazovanjeDTO> administrativnoAngazovanje) {
        this.id = id;
        this.naziv = naziv;
        this.fakultet = fakultet;
        this.godineStudija = godineStudija;
        this.administrativnoAngazovanje = administrativnoAngazovanje;
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

	public FakultetDTO getFakultet() {
		return fakultet;
	}

	public void setFakultet(FakultetDTO fakultet) {
		this.fakultet = fakultet;
	}

	public List<GodinaStudijaDTO> getGodineStudija() {
		return godineStudija;
	}

	public void setGodineStudija(List<GodinaStudijaDTO> godineStudija) {
		this.godineStudija = godineStudija;
	}

	public List<AdministrativnoAngazovanjeDTO> getAdministrativnoAngazovanje() {
		return administrativnoAngazovanje;
	}

	public void setAdministrativnoAngazovanje(List<AdministrativnoAngazovanjeDTO> administrativnoAngazovanje) {
		this.administrativnoAngazovanje = administrativnoAngazovanje;
	}

    
}
