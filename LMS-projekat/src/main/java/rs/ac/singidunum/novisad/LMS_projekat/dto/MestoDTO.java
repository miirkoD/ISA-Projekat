package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.util.ArrayList;
import java.util.List;

public class MestoDTO {

    private Long id;
    private String naziv;
    private DrzavaDTO drzava;
    private List<AdresaDTO> adrese = new ArrayList<>();

    public MestoDTO() {}

    
    public MestoDTO(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public MestoDTO(Long id, String naziv, DrzavaDTO drzava) {
        this.id = id;
        this.naziv = naziv;
        this.drzava = drzava;
    }

    public MestoDTO(Long id, String naziv, DrzavaDTO drzava, List<AdresaDTO> adrese) {
        this.id = id;
        this.naziv = naziv;
        this.drzava = drzava;
        this.adrese = adrese;
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


	public DrzavaDTO getDrzava() {
		return drzava;
	}


	public void setDrzava(DrzavaDTO drzava) {
		this.drzava = drzava;
	}


	public List<AdresaDTO> getAdrese() {
		return adrese;
	}


	public void setAdrese(List<AdresaDTO> adrese) {
		this.adrese = adrese;
	}

  

}
