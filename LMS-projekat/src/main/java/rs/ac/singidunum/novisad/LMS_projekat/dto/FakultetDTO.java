package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.util.ArrayList;
import java.util.List;

public class FakultetDTO {

    private Long id;
    private String naziv;
    private UniverzitetDTO univerzitet;
    private List<StudijskiProgramDTO> studijskiProgrami = new ArrayList<>();
    private List<AdministrativnoAngazovanjeDTO> administrativnoAngazovanje = new ArrayList<>();

    public FakultetDTO() {}

    public FakultetDTO(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public FakultetDTO(Long id, String naziv, UniverzitetDTO univerzitet) {
        this.id = id;
        this.naziv = naziv;
        this.univerzitet = univerzitet;
    }

    public FakultetDTO(Long id, String naziv, UniverzitetDTO univerzitet, List<StudijskiProgramDTO> studijskiProgrami, List<AdministrativnoAngazovanjeDTO> administrativnoAngazovanje) {
        this.id = id;
        this.naziv = naziv;
        this.univerzitet = univerzitet;
        this.studijskiProgrami = studijskiProgrami;
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

	public UniverzitetDTO getUniverzitet() {
		return univerzitet;
	}

	public void setUniverzitet(UniverzitetDTO univerzitet) {
		this.univerzitet = univerzitet;
	}

	public List<StudijskiProgramDTO> getStudijskiProgrami() {
		return studijskiProgrami;
	}

	public void setStudijskiProgrami(List<StudijskiProgramDTO> studijskiProgrami) {
		this.studijskiProgrami = studijskiProgrami;
	}

	public List<AdministrativnoAngazovanjeDTO> getAdministrativnoAngazovanje() {
		return administrativnoAngazovanje;
	}

	public void setAdministrativnoAngazovanje(List<AdministrativnoAngazovanjeDTO> administrativnoAngazovanje) {
		this.administrativnoAngazovanje = administrativnoAngazovanje;
	}

    

}
