package rs.ac.singidunum.novisad.LMS_projekat.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Upis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private int brojUpisa;
	
	@ManyToOne(optional = false)
	private GodinaStudija godinaStudija;
	
	@ManyToOne(optional = false)
	private SkolskaGodina skolskaGodina;
	
	@ManyToOne(optional=false)
	private StudentNaStudijskomProgramu studentNaStudijskomProgramu;

	public Upis() {
		super();
	}

	public Upis(Long id, int brojUpisa, GodinaStudija godinaStudija, SkolskaGodina skolskaGodina,
			StudentNaStudijskomProgramu studentNaStudijskomProgramu) {
		super();
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

	public GodinaStudija getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudija godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public SkolskaGodina getSkolskaGodina() {
		return skolskaGodina;
	}

	public void setSkolskaGodina(SkolskaGodina skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}

	public StudentNaStudijskomProgramu getStudentNaStudijskomProgramu() {
		return studentNaStudijskomProgramu;
	}

	public void setStudentNaStudijskomProgramu(StudentNaStudijskomProgramu studentNaStudijskomProgramu) {
		this.studentNaStudijskomProgramu = studentNaStudijskomProgramu;
	}
	
}
