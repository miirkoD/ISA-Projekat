package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.util.ArrayList;
import java.util.List;

public class StudentDTO {

    private Long id;
    private AdresaDTO adresa;
    private List<DodelaDTO> dodele = new ArrayList<>();
    private List<StudentNaStudijskomProgramuDTO> studentiNaStudijskimProgramima = new ArrayList<>();

    public StudentDTO() {}

    
    public StudentDTO(Long id) {
        this.id = id;
    }

    public StudentDTO(Long id, AdresaDTO adresa) {
        this.id = id;
        this.adresa = adresa;
    }

    public StudentDTO(Long id, AdresaDTO adresa, List<DodelaDTO> dodele, List<StudentNaStudijskomProgramuDTO> studentiNaStudijskimProgramima) {
        this.id = id;
        this.adresa = adresa;
        this.dodele = dodele;
        this.studentiNaStudijskimProgramima = studentiNaStudijskimProgramima;
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public AdresaDTO getAdresa() {
		return adresa;
	}


	public void setAdresa(AdresaDTO adresa) {
		this.adresa = adresa;
	}


	public List<DodelaDTO> getDodele() {
		return dodele;
	}


	public void setDodele(List<DodelaDTO> dodele) {
		this.dodele = dodele;
	}


	public List<StudentNaStudijskomProgramuDTO> getStudentiNaStudijskimProgramima() {
		return studentiNaStudijskimProgramima;
	}


	public void setStudentiNaStudijskimProgramima(List<StudentNaStudijskomProgramuDTO> studentiNaStudijskimProgramima) {
		this.studentiNaStudijskimProgramima = studentiNaStudijskimProgramima;
	}

    

}
