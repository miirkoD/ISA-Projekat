package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.util.ArrayList;
import java.util.List;

public class InstrumentEvaluacijeZnanjaDTO {

    private Long id;
    private String naziv;
    private List<NastavniMaterijalDTO> nastavniMaterijali = new ArrayList<>();
    private List<EvaluacijaZnanjaDTO> evaluacijaZnanja = new ArrayList<>();

    public InstrumentEvaluacijeZnanjaDTO() {}

    public InstrumentEvaluacijeZnanjaDTO(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public InstrumentEvaluacijeZnanjaDTO(Long id, String naziv, List<NastavniMaterijalDTO> nastavniMaterijali, List<EvaluacijaZnanjaDTO> evaluacijaZnanja) {
        this.id = id;
        this.naziv = naziv;
        this.nastavniMaterijali = nastavniMaterijali;
        this.evaluacijaZnanja = evaluacijaZnanja;
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

	public List<NastavniMaterijalDTO> getNastavniMaterijali() {
		return nastavniMaterijali;
	}

	public void setNastavniMaterijali(List<NastavniMaterijalDTO> nastavniMaterijali) {
		this.nastavniMaterijali = nastavniMaterijali;
	}

	public List<EvaluacijaZnanjaDTO> getEvaluacijaZnanja() {
		return evaluacijaZnanja;
	}

	public void setEvaluacijaZnanja(List<EvaluacijaZnanjaDTO> evaluacijaZnanja) {
		this.evaluacijaZnanja = evaluacijaZnanja;
	}

}