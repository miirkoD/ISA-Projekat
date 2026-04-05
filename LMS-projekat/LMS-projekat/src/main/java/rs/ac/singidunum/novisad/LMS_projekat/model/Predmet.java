package rs.ac.singidunum.novisad.LMS_projekat.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Predmet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@Column(nullable = false)
	private int espb;
	
	@Column(nullable = false)
	private boolean obavezan;
	
	@Column(nullable = false)
	private int brojPredavanja;
	
	@Column(nullable = false)
	private int brojVezbi;
	
	@Column(nullable = false)
	private int drugiObliciNastave;
	
	@Column(nullable = false)
	private int istrazivackiRad;
	
	@Column(nullable = false)
	private int brojOstalihCasova;
	
	@ManyToOne(optional = false)
	private GodinaStudija godinaStudija;
	
	@ManyToOne(optional = false)
	private SadrzajPredmeta sadrzajPredmeta;
	
	@ManyToOne(optional = false)
	private Ishod ishod;
	
	@ManyToOne(optional=false)
	private ObrazovniCilj obrazovniCilj;
	
	@ManyToOne(optional=false)
	private RealizacijaPredmeta realizacijaPredmeta;
	
}
