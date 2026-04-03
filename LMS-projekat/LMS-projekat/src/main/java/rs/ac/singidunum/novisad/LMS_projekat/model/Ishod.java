package rs.ac.singidunum.novisad.LMS_projekat.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

@Entity
public class Ishod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@Column(nullable = false)
	@Lob
	private String opis;
	
	@OneToMany(mappedBy = "ishod", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Predmet> predmeti = new ArrayList<Predmet>();
}
