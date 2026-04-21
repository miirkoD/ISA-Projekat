package rs.ac.singidunum.novisad.LMS_projekat.dto;

public class UpisDTO {

    private Long id;
    private int brojUpisa;
    private GodinaStudijaDTO godinaStudija;
    private SkolskaGodinaDTO skolskaGodina;
    private StudentNaStudijskomProgramuDTO studentNaStudijskomProgramu;

    public UpisDTO() {}

    public UpisDTO(Long id, int brojUpisa) {
        this.id = id;
        this.brojUpisa = brojUpisa;
    }

    public UpisDTO(Long id, int brojUpisa, GodinaStudijaDTO godinaStudija, SkolskaGodinaDTO skolskaGodina, StudentNaStudijskomProgramuDTO studentNaStudijskomProgramu) {
        this.id = id;
        this.brojUpisa = brojUpisa;
        this.godinaStudija = godinaStudija;
        this.skolskaGodina = skolskaGodina;
        this.studentNaStudijskomProgramu = studentNaStudijskomProgramu;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBrojUpisa() {
		return brojUpisa;
	}

	public void setBrojUpisa(int brojUpisa) {
		this.brojUpisa = brojUpisa;
	}

	public GodinaStudijaDTO getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudijaDTO godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public SkolskaGodinaDTO getSkolskaGodina() {
		return skolskaGodina;
	}

	public void setSkolskaGodina(SkolskaGodinaDTO skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}

	public StudentNaStudijskomProgramuDTO getStudentNaStudijskomProgramu() {
		return studentNaStudijskomProgramu;
	}

	public void setStudentNaStudijskomProgramu(StudentNaStudijskomProgramuDTO studentNaStudijskomProgramu) {
		this.studentNaStudijskomProgramu = studentNaStudijskomProgramu;
	}

    
}
