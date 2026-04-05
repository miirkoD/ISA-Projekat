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
public class RealizacijaPredmeta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional = false)
	private Predmet predmet;
	
	@ManyToOne(optional = false)
	private SkolskaGodina skolskaGodina;
	
	@OneToMany(mappedBy = "realizacijaPredmeta")
	private List<EvaluacijaZnanja> evaluacijeZnanja=new ArrayList<EvaluacijaZnanja>();
	
	@OneToMany(mappedBy = "realizacijaPredmeta")
	private List<Polaganje> polaganja= new ArrayList<Polaganje>();
	
	@OneToMany(mappedBy = "realizacijaPredmeta")
	private List<Angazovanje>angazovanja=new ArrayList<Angazovanje>();
	
	@OneToMany(mappedBy = "realizacijaPredmeta")
	private List<TerminNastave> terminiNastave=new ArrayList<TerminNastave>();
	
	@OneToMany(mappedBy = "realizacijaPredmeta")
	private List<NastavniMaterijal>nastavniMaterijali=new ArrayList<NastavniMaterijal>();	
	
}
