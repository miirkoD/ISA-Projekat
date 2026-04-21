package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.util.ArrayList;
import java.util.List;

public class StudentNaStudijskomProgramuDTO {

    private Long id;
    private String brojIndeksa;
    private StudentDTO student;
    private List<PohadjanjeDTO> pohadjanja = new ArrayList<>();
    private List<PolaganjeDTO> polaganja = new ArrayList<>();
    private List<UpisDTO> upisi = new ArrayList<>();

    public StudentNaStudijskomProgramuDTO() {}

    public StudentNaStudijskomProgramuDTO(Long id, String brojIndeksa) {
        this.id = id;
        this.brojIndeksa = brojIndeksa;
    }

    public StudentNaStudijskomProgramuDTO(Long id, String brojIndeksa, StudentDTO student) {
        this.id = id;
        this.brojIndeksa = brojIndeksa;
        this.student = student;
    }

    public StudentNaStudijskomProgramuDTO(Long id, String brojIndeksa, StudentDTO student, List<PohadjanjeDTO> pohadjanja, List<PolaganjeDTO> polaganja, List<UpisDTO> upisi) {
        this.id = id;
        this.brojIndeksa = brojIndeksa;
        this.student = student;
        this.pohadjanja = pohadjanja;
        this.polaganja = polaganja;
        this.upisi = upisi;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public List<PohadjanjeDTO> getPohadjanja() {
		return pohadjanja;
	}

	public void setPohadjanja(List<PohadjanjeDTO> pohadjanja) {
		this.pohadjanja = pohadjanja;
	}

	public List<PolaganjeDTO> getPolaganja() {
		return polaganja;
	}

	public void setPolaganja(List<PolaganjeDTO> polaganja) {
		this.polaganja = polaganja;
	}

	public List<UpisDTO> getUpisi() {
		return upisi;
	}

	public void setUpisi(List<UpisDTO> upisi) {
		this.upisi = upisi;
	}

    

}
