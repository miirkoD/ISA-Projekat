package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class InstrumentEvaluacijeZnanja {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@OneToMany(mappedBy = "instrumentEvaluacijeZnanja", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<NastavniMaterijal> nastavniMaterijali = new ArrayList<NastavniMaterijal>();
	
}
