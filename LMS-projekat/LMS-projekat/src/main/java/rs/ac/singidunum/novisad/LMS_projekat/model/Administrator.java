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
public class Administrator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 @OneToMany(mappedBy = "administrator")
	 private List<Dodela> dodele = new ArrayList<Dodela>();

	public Administrator() {
		super();
	}

	public Administrator(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Dodela> getDodele() {
		return dodele;
	}

	public void setDodele(List<Dodela> dodele) {
		this.dodele = dodele;
	}

    
    
	
	
}
