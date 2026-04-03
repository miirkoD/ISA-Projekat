package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

public class SadrzajPredmeta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;

	@Column(nullable = false)
	@Lob
	private String opis;
	
	@OneToMany(mappedBy = "sadrzajPredmeta", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Predmet> predmeti = new ArrayList<Predmet>();
}
