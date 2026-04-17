package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.util.ArrayList;
import java.util.List;

public class TipEvaluacijeZnanjaDTO {

    private Long id;
    private String naziv;
    private List<EvaluacijaZnanjaDTO> evaluacijeZnanja = new ArrayList<>();

    public TipEvaluacijeZnanjaDTO() {}

    public TipEvaluacijeZnanjaDTO(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public TipEvaluacijeZnanjaDTO(Long id, String naziv, List<EvaluacijaZnanjaDTO> evaluacijeZnanja) {
        this.id = id;
        this.naziv = naziv;
        this.evaluacijeZnanja = evaluacijeZnanja;
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

	public List<EvaluacijaZnanjaDTO> getEvaluacijeZnanja() {
		return evaluacijeZnanja;
	}

	public void setEvaluacijeZnanja(List<EvaluacijaZnanjaDTO> evaluacijeZnanja) {
		this.evaluacijeZnanja = evaluacijeZnanja;
	}

    

}