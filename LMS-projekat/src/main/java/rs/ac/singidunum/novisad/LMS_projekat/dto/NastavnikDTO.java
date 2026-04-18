package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.util.ArrayList;
import java.util.List;

public class NastavnikDTO {

    private Long id;
    private String biografija;
    private List<DodelaDTO> dodele = new ArrayList<>();
    private List<ZvanjeDTO> zvanja = new ArrayList<>();
    private List<AdministrativnoAngazovanjeDTO> administrativnoAngazovanje = new ArrayList<>();
    private List<AngazovanjeDTO> angazovanja = new ArrayList<>();

    public NastavnikDTO() {}

  
    public NastavnikDTO(Long id, String biografija) {
        this.id = id;
        this.biografija = biografija;
    }

    public NastavnikDTO(Long id, String biografija, List<DodelaDTO> dodele, List<ZvanjeDTO> zvanja, List<AdministrativnoAngazovanjeDTO> administrativnoAngazovanje, List<AngazovanjeDTO> angazovanja) {
        this.id = id;
        this.biografija = biografija;
        this.dodele = dodele;
        this.zvanja = zvanja;
        this.administrativnoAngazovanje = administrativnoAngazovanje;
        this.angazovanja = angazovanja;
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getBiografija() {
		return biografija;
	}


	public void setBiografija(String biografija) {
		this.biografija = biografija;
	}


	public List<DodelaDTO> getDodele() {
		return dodele;
	}


	public void setDodele(List<DodelaDTO> dodele) {
		this.dodele = dodele;
	}


	public List<ZvanjeDTO> getZvanja() {
		return zvanja;
	}


	public void setZvanja(List<ZvanjeDTO> zvanja) {
		this.zvanja = zvanja;
	}


	public List<AdministrativnoAngazovanjeDTO> getAdministrativnoAngazovanje() {
		return administrativnoAngazovanje;
	}


	public void setAdministrativnoAngazovanje(List<AdministrativnoAngazovanjeDTO> administrativnoAngazovanje) {
		this.administrativnoAngazovanje = administrativnoAngazovanje;
	}


	public List<AngazovanjeDTO> getAngazovanja() {
		return angazovanja;
	}


	public void setAngazovanja(List<AngazovanjeDTO> angazovanja) {
		this.angazovanja = angazovanja;
	}

   

}
