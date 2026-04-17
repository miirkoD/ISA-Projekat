package rs.ac.singidunum.novisad.LMS_projekat.dto;

public class IshodDTO {

    private Long id;
    private String naziv;
    private String opis;
    private PredmetDTO predmet;

    public IshodDTO() {}

    public IshodDTO(Long id, String naziv, String opis) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
    }

    public IshodDTO(Long id, String naziv, String opis, PredmetDTO predmet) {
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

	public PredmetDTO getPredmet() {
		return predmet;
	}

	public void setPredmet(PredmetDTO predmet) {
		this.predmet = predmet;
	}
    
}