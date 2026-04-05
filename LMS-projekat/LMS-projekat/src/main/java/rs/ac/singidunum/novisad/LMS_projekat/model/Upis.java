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
	
	@Column(nullable = false)
	private int godinaStudija;
	
	@ManyToOne(optional = false)
	private SkolskaGodina skolskaGodina;
	
	@ManyToOne(optional=false)
	private StudentNaStudijskomProgramu studentNaStudijskomProgramu;
}
