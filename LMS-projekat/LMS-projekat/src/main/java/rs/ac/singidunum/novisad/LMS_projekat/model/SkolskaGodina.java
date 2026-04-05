package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.time.LocalDate;
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
public class SkolskaGodina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private LocalDate pocetak;
	
	@Column(nullable = false)
	private LocalDate kraj;
	
	@ManyToOne(optional=false)
	private GodinaStudija godinaStudija;
	
	@ManyToOne(optional=false)
	private RealizacijaPredmeta realizacijaPredmeta;
	
	@OneToMany(mappedBy = "skolskaGodina")
	private List<Upis>upisi=new ArrayList<Upis>();

	public SkolskaGodina() {
		super();
	}
}
