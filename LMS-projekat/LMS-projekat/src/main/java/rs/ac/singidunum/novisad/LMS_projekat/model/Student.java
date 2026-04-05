package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "student")
    private List<Dodela> dodele = new ArrayList<Dodela>();
	
	@OneToMany(mappedBy = "student")
	private List<StudentNaStudijskomProgramu> studentiNaStudijskimProgramima = new ArrayList<StudentNaStudijskomProgramu>();
	
	@ManyToOne(optional = false)
	private Adresa adresa;
	
}
