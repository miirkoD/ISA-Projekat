package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.util.ArrayList;
import java.util.List;

public class AdministrativniSluzbenikDTO {

    private Long id;
    private List<DodelaDTO> dodele = new ArrayList<>();

    public AdministrativniSluzbenikDTO() {}

   
    public AdministrativniSluzbenikDTO(Long id) {
        this.id = id;
    }

    public AdministrativniSluzbenikDTO(Long id, List<DodelaDTO> dodele) {
        this.id = id;
        this.dodele = dodele;
    }


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<DodelaDTO> getDodele() {
		return dodele;
	}

	public void setDodele(List<DodelaDTO> dodele) {
		this.dodele = dodele;
	}



}
