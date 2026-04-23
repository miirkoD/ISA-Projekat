package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.util.ArrayList;
import java.util.List;

public class GodinaStudijaDTO {

    private Long id;
    private String naziv;
    private StudijskiProgramDTO studijskiProgram;
    private List<SkolskaGodinaDTO> skolskaGodina = new ArrayList<>();
    private List<PredmetDTO> predmeti = new ArrayList<>();
    private List<UpisDTO> upisi = new ArrayList<>();

    public GodinaStudijaDTO() {}

    public GodinaStudijaDTO(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public GodinaStudijaDTO(Long id, String naziv, StudijskiProgramDTO studijskiProgram) {
        this.id = id;
        this.naziv = naziv;
        this.studijskiProgram = studijskiProgram;
    }

    public GodinaStudijaDTO(Long id, String naziv, StudijskiProgramDTO studijskiProgram, List<SkolskaGodinaDTO> skolskaGodina, List<PredmetDTO> predmeti, List<UpisDTO> upisi) {
        this.id = id;
        this.naziv = naziv;
        this.studijskiProgram = studijskiProgram;
        this.skolskaGodina = skolskaGodina;
        this.predmeti = predmeti;
        this.upisi = upisi;
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

	public StudijskiProgramDTO getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgramDTO studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}

	public List<SkolskaGodinaDTO> getSkolskaGodina() {
		return skolskaGodina;
	}

	public void setSkolskaGodina(List<SkolskaGodinaDTO> skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}

	public List<PredmetDTO> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<PredmetDTO> predmeti) {
		this.predmeti = predmeti;
	}

	public List<UpisDTO> getUpisi() {
		return upisi;
	}

	public void setUpisi(List<UpisDTO> upisi) {
		this.upisi = upisi;
	}

    

}
