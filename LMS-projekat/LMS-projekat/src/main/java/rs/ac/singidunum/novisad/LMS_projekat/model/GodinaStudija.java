package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class GodinaStudija {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String naziv;
	
	@ManyToOne(optional=false)
	private StudijskiProgram studijskiProgram;
	
	@OneToMany(mappedBy = "godinaStudija")
	private List<SkolskaGodina> skolskaGodina = new ArrayList<SkolskaGodina>();

	public GodinaStudija() {
		super();
	}
}
