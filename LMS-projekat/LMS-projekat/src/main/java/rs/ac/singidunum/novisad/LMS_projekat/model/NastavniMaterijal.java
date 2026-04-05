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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class NastavniMaterijal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@Column(nullable = false)
	@Lob
	private String opis;
	
	@ManyToOne(optional = false)
	private TipNastavnogMaterijala tipNastavnogMaterijala;
	
	@ManyToOne(optional = false)
	private InstrumentEvaluacijeZnanja instrumentEvaluacijeZnanja;
	
	@OneToMany(mappedBy = "nastavniMaterijal", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Datoteka> datoteke = new ArrayList<Datoteka>();
	
	@OneToMany(mappedBy = "nastavniMaterijal")
	private List<TerminNastave> terminiNastave = new ArrayList<TerminNastave>();
	
	@ManyToOne(optional=false)
	private RealizacijaPredmeta realizacijaPredmeta;

}
