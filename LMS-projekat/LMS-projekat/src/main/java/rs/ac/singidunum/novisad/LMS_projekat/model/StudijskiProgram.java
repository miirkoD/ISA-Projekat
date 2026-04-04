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
public class StudijskiProgram {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@ManyToOne(optional=false)
	private Fakultet fakultet;
	
	@OneToMany(mappedBy = "studijskiProgram")
	private List<GodinaStudija> godineStudija=new ArrayList<GodinaStudija>();
	
	public StudijskiProgram() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
