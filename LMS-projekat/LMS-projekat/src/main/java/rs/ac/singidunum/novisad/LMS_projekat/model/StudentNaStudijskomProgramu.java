package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class StudentNaStudijskomProgramu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String brojIndeksa;
	
	@ManyToOne(optional = false)
	private Student student;
	
	@OneToMany(mappedBy = "studentiNaStudijskimProgramima")
	private List<Pohadjanje> pohadjanja = new ArrayList<Pohadjanje>();
	
	@OneToMany(mappedBy = "studentiNaStudijskimProgramima", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Polaganje> polaganja = new ArrayList<Polaganje>();
}
