package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.util.ArrayList;
import java.util.List;

public class TipNastaveDTO {

    private Long id;
    private String naziv;
    private List<TerminNastaveDTO> terminiNastave = new ArrayList<>();

    public TipNastaveDTO() {}

    public TipNastaveDTO(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public TipNastaveDTO(Long id, String naziv, List<TerminNastaveDTO> terminiNastave) {
        this.id = id;
        this.naziv = naziv;
        this.terminiNastave = terminiNastave;
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

	public List<TerminNastaveDTO> getTerminiNastave() {
		return terminiNastave;
	}

	public void setTerminiNastave(List<TerminNastaveDTO> terminiNastave) {
		this.terminiNastave = terminiNastave;
	}

    

}