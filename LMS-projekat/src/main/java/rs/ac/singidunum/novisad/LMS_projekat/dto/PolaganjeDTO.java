package rs.ac.singidunum.novisad.LMS_projekat.dto;

public class PolaganjeDTO {

    private Long id;
    private int bodovi;
    private String napomena;
    private StudentNaStudijskomProgramuDTO studentiNaStudijskimProgramima;
    private EvaluacijaZnanjaDTO evaluacijaZnanja;

    public PolaganjeDTO() {}

    public PolaganjeDTO(Long id, int bodovi, String napomena) {
        this.id = id;
        this.bodovi = bodovi;
        this.napomena = napomena;
    }
    
	  public PolaganjeDTO(Long id, int bodovi, String napomena, StudentNaStudijskomProgramuDTO studentiNaStudijskimProgramima, EvaluacijaZnanjaDTO evaluacijaZnanja) {
	  this.id = id;
	  this.bodovi = bodovi;
	  this.napomena = napomena;
	  this.studentiNaStudijskimProgramima = studentiNaStudijskimProgramima;
	  this.evaluacijaZnanja = evaluacijaZnanja;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBodovi() {
		return bodovi;
	}

	public void setBodovi(int bodovi) {
		this.bodovi = bodovi;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public EvaluacijaZnanjaDTO getEvaluacijaZnanja() {
		return evaluacijaZnanja;
	}

	public void setEvaluacijaZnanja(EvaluacijaZnanjaDTO evaluacijaZnanja) {
		this.evaluacijaZnanja = evaluacijaZnanja;
	}

	public StudentNaStudijskomProgramuDTO getStudentiNaStudijskimProgramima() {
		return studentiNaStudijskimProgramima;
	}

	public void setStudentiNaStudijskimProgramima(StudentNaStudijskomProgramuDTO studentiNaStudijskimProgramima) {
		this.studentiNaStudijskimProgramima = studentiNaStudijskimProgramima;
	}
	

}