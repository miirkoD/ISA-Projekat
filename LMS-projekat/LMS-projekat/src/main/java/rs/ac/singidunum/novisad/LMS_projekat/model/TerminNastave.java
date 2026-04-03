package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class TerminNastave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDateTime pocetak;
	
	@Column(nullable = true)
	private LocalDateTime kraj;
	
	@ManyToOne(optional = false)
	private TipNastave tipNastave;
	
	@OneToMany(mappedBy = "terminNastave", cascade = CascadeType.ALL, orphanRemoval = true )
	private List<Angazovanje> angazovanja = new ArrayList<Angazovanje>();
}
