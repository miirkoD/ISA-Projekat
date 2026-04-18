package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.util.ArrayList;
import java.util.List;

public class RealizacijaPredmetaDTO {

    private Long id;
    private PredmetDTO predmet;
    private SkolskaGodinaDTO skolskaGodina;
    private List<EvaluacijaZnanjaDTO> evaluacijeZnanja = new ArrayList<>();
    private List<AngazovanjeDTO> angazovanja = new ArrayList<>();
    private List<TerminNastaveDTO> terminiNastave = new ArrayList<>();
    private List<NastavniMaterijalDTO> nastavniMaterijali = new ArrayList<>();
    private List<PohadjanjeDTO> pohadjanje = new ArrayList<>();

    public RealizacijaPredmetaDTO() {}

    public RealizacijaPredmetaDTO(Long id) {
        this.id = id;
    }
    
    public RealizacijaPredmetaDTO(Long id, PredmetDTO predmet, SkolskaGodinaDTO skolskaGodina) {
        this.id = id;
        this.predmet = predmet;
        this.skolskaGodina = skolskaGodina;
    }
    
	public RealizacijaPredmetaDTO(Long id, PredmetDTO predmet, SkolskaGodinaDTO skolskaGodina, List<EvaluacijaZnanjaDTO> evaluacijeZnanja, List<AngazovanjeDTO> angazovanja, List<TerminNastaveDTO> terminiNastave, List<NastavniMaterijalDTO> nastavniMaterijali, List<PohadjanjeDTO> pohadjanje) {
	  this.id = id;
	  this.predmet = predmet;
	  this.skolskaGodina = skolskaGodina;
	  this.evaluacijeZnanja = evaluacijeZnanja;
	  this.angazovanja = angazovanja;
	  this.terminiNastave = terminiNastave;
	  this.nastavniMaterijali = nastavniMaterijali;
	  this.pohadjanje = pohadjanje;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PredmetDTO getPredmet() {
		return predmet;
	}

	public void setPredmet(PredmetDTO predmet) {
		this.predmet = predmet;
	}

	public List<EvaluacijaZnanjaDTO> getEvaluacijeZnanja() {
		return evaluacijeZnanja;
	}

	public void setEvaluacijeZnanja(List<EvaluacijaZnanjaDTO> evaluacijeZnanja) {
		this.evaluacijeZnanja = evaluacijeZnanja;
	}

	public List<AngazovanjeDTO> getAngazovanja() {
		return angazovanja;
	}

	public void setAngazovanja(List<AngazovanjeDTO> angazovanja) {
		this.angazovanja = angazovanja;
	}

	public List<TerminNastaveDTO> getTerminiNastave() {
		return terminiNastave;
	}

	public void setTerminiNastave(List<TerminNastaveDTO> terminiNastave) {
		this.terminiNastave = terminiNastave;
	}

	public List<NastavniMaterijalDTO> getNastavniMaterijali() {
		return nastavniMaterijali;
	}

	public void setNastavniMaterijali(List<NastavniMaterijalDTO> nastavniMaterijali) {
		this.nastavniMaterijali = nastavniMaterijali;
	}

	public List<PohadjanjeDTO> getPohadjanje() {
		return pohadjanje;
	}

	public void setPohadjanje(List<PohadjanjeDTO> pohadjanje) {
		this.pohadjanje = pohadjanje;
	}

	public SkolskaGodinaDTO getSkolskaGodina() {
		return skolskaGodina;
	}

	public void setSkolskaGodina(SkolskaGodinaDTO skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}
	
    

}