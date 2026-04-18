package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.util.ArrayList;
import java.util.List;

public class DrzavaDTO {

    private Long id;
    private String naziv;
    private List<MestoDTO> mesta = new ArrayList<>();

    public DrzavaDTO() {}

   
    public DrzavaDTO(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public DrzavaDTO(Long id, String naziv, List<MestoDTO> mesta) {
        this.id = id;
        this.naziv = naziv;
        this.mesta = mesta;
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


	public List<MestoDTO> getMesta() {
		return mesta;
	}


	public void setMesta(List<MestoDTO> mesta) {
		this.mesta = mesta;
	}

   

}
