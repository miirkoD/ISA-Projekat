package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
	@Lob
	private String opis;
	
	@Column
	private URL url;
	
	@OneToMany(mappedBy = "datoteka")
	private List<PravoPristupa> pravaPristupa = new ArrayList<PravoPristupa>();

	@ManyToOne
    private NastavniMaterijal nastavniMaterijal;

	public Datoteka() {
		super();
	}

	public Datoteka(Long id, String naziv, String opis, URL url, List<PravoPristupa> pravaPristupa,
			NastavniMaterijal nastavniMaterijal) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.url = url;
		this.pravaPristupa = pravaPristupa;
		this.nastavniMaterijal = nastavniMaterijal;
	}

	public Datoteka(Long id, String naziv, String opis, URL url, NastavniMaterijal nastavniMaterijal) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.url = url;
		this.nastavniMaterijal = nastavniMaterijal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public List<PravoPristupa> getPravaPristupa() {
		return pravaPristupa;
	}

	public void setPravaPristupa(List<PravoPristupa> pravaPristupa) {
		this.pravaPristupa = pravaPristupa;
	}

	public NastavniMaterijal getNastavniMaterijal() {
		return nastavniMaterijal;
	}

	public void setNastavniMaterijal(NastavniMaterijal nastavniMaterijal) {
		this.nastavniMaterijal = nastavniMaterijal;
	}
	
}
