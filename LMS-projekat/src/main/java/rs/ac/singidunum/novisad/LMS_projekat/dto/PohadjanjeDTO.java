package rs.ac.singidunum.novisad.LMS_projekat.dto;

public class PohadjanjeDTO {

    private Long id;
    private Integer konacnaOcena;
    private StudentNaStudijskomProgramuDTO studentiNaStudijskimProgramima;
    private RealizacijaPredmetaDTO realizacijaPredmeta;

    public PohadjanjeDTO() {}

    public PohadjanjeDTO(Long id, Integer konacnaOcena) {
        this.id = id;
        this.konacnaOcena = konacnaOcena;
    }

    public PohadjanjeDTO(Long id, Integer konacnaOcena, StudentNaStudijskomProgramuDTO studentiNaStudijskimProgramima, RealizacijaPredmetaDTO realizacijaPredmeta) {
	  this.id = id;
	  this.konacnaOcena = konacnaOcena;
	  this.studentiNaStudijskimProgramima = studentiNaStudijskimProgramima;
	  this.realizacijaPredmeta = realizacijaPredmeta;
}
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getKonacnaOcena() {
		return konacnaOcena;
	}

	public void setKonacnaOcena(Integer konacnaOcena) {
		this.konacnaOcena = konacnaOcena;
	}

	public RealizacijaPredmetaDTO getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmetaDTO realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public StudentNaStudijskomProgramuDTO getStudentiNaStudijskimProgramima() {
		return studentiNaStudijskimProgramima;
	}

	public void setStudentiNaStudijskimProgramima(StudentNaStudijskomProgramuDTO studentiNaStudijskimProgramima) {
		this.studentiNaStudijskimProgramima = studentiNaStudijskimProgramima;
	}
	

}