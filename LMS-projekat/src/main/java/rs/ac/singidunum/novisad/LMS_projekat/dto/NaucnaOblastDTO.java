package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.util.ArrayList;
import java.util.List;

public class NaucnaOblastDTO {

    private Long id;
    private String naziv;
    private List<ZvanjeDTO> zvanja = new ArrayList<>();

    public NaucnaOblastDTO() {}

    public NaucnaOblastDTO(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public NaucnaOblastDTO(Long id, String naziv, List<ZvanjeDTO> zvanja) {
        this.id = id;
        this.naziv = naziv;
        this.zvanja = zvanja;
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

	public List<ZvanjeDTO> getZvanja() {
		return zvanja;
	}

	public void setZvanja(List<ZvanjeDTO> zvanja) {
		this.zvanja = zvanja;
	}

    

}
