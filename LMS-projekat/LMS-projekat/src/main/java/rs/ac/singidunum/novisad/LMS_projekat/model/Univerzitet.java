package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Univerzitet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	@Column(nullable = false)
	private LocalDateTime datumOsnivanja;
	@ManyToOne(optional = false)
	private Adresa adresa;
	@OneToMany(mappedBy = "univerzitet")
	private List<Fakultet> fakulteti=new ArrayList<Fakultet>();
	
	public Univerzitet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
