package rs.ac.singidunum.novisad.LMS_projekat.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Nastavnik {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Lob
	private String biografija;
	
	@OneToMany(mappedBy = "nastavnik")
	private List<Dodela> dodele = new ArrayList<Dodela>();
	 
	@OneToMany(mappedBy = "nastavnik")
	private List<Zvanje> zvanja = new ArrayList<Zvanje>();
	
	@OneToMany(mappedBy = "nastavnik")
	private List<AdministrativnoAngazovanje> angazovanje= new ArrayList<AdministrativnoAngazovanje>();
	  
	@OneToMany(mappedBy = "nastavnik", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Angazovanje> angazovanja = new ArrayList<Angazovanje>();
   
}
