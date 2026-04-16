package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DatotekaDTO {

    private Long id;
    private String naziv;
    private String opis;
    private URL url;
    private NastavniMaterijalDTO nastavniMaterijal;
    private List<PravoPristupaDTO> pravaPristupa = new ArrayList<>();

    public DatotekaDTO() {}

  
    public DatotekaDTO(Long id, String naziv, String opis, URL url) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.url = url;
    }

    public DatotekaDTO(Long id, String naziv, String opis, URL url, NastavniMaterijalDTO nastavniMaterijal) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.url = url;
        this.nastavniMaterijal = nastavniMaterijal;
    }

    public DatotekaDTO(Long id, String naziv, String opis, URL url, NastavniMaterijalDTO nastavniMaterijal, List<PravoPristupaDTO> pravaPristupa) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.url = url;
        this.nastavniMaterijal = nastavniMaterijal;
        this.pravaPristupa = pravaPristupa;
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


	public URL getUrl() {
		return url;
	}


	public void setUrl(URL url) {
		this.url = url;
	}


	public NastavniMaterijalDTO getNastavniMaterijal() {
		return nastavniMaterijal;
	}


	public void setNastavniMaterijal(NastavniMaterijalDTO nastavniMaterijal) {
		this.nastavniMaterijal = nastavniMaterijal;
	}


	public List<PravoPristupaDTO> getPravaPristupa() {
		return pravaPristupa;
	}


	public void setPravaPristupa(List<PravoPristupaDTO> pravaPristupa) {
		this.pravaPristupa = pravaPristupa;
	}

   

}
