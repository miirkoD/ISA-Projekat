package rs.ac.singidunum.novisad.LMS_projekat.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class ObrazovniCilj {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;

	@Column(nullable = false)
	@Lob
	private String opis;
	
	@ManyToOne(optional=false)
	private Predmet predmet;

	public ObrazovniCilj() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ObrazovniCilj(Long id, String naziv, String opis, Predmet predmet) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.predmet = predmet;
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

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	
}
