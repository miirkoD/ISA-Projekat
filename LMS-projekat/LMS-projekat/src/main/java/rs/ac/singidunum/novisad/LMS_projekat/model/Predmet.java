package rs.ac.singidunum.novisad.LMS_projekat.model;

import jakarta.persistence.CascadeType;
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
	
	@Column(nullable = false)
	private int godinaStudija;
	
	@ManyToOne(optional = false)
	private SadrzajPredmeta sadrzajPredmeta;
	
<<<<<<< HEAD
	@ManyToOne(optional = false)
	private Ishod ishod;
	
	@ManyToOne(optional=false)
	private ObrazovniCilj obrazovniCilj;
=======
	@ManyToOne(optional = false)
	private Ishod ishod;
	
	@ManyToOne(optional = false)
	private ObrazovniCilj obrazovniCilj;
	
>>>>>>> e94cb8a4c08b84c76a590709224b909930cf54ec
}
