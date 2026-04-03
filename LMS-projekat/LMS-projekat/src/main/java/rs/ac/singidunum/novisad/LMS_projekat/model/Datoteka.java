package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Datoteka {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@Column
	private String opis;
	
	@Column
	private URL url;
	
	@OneToMany(mappedBy = "datoteka")
	private List<PravoPristupa> pravaPristupa = new ArrayList<PravoPristupa>();

	@ManyToOne
    @JoinColumn(name = "nastavni_materijal_id")
    private NastavniMaterijal nastavniMaterijal;
}
