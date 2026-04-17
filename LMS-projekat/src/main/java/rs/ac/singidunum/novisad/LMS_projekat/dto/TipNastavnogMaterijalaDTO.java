package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.util.ArrayList;
import java.util.List;

public class TipNastavnogMaterijalaDTO {

    private Long id;
    private String naziv;
    private List<NastavniMaterijalDTO> nastavniMaterijali = new ArrayList<>();

    public TipNastavnogMaterijalaDTO() {}

    public TipNastavnogMaterijalaDTO(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public TipNastavnogMaterijalaDTO(Long id, String naziv, List<NastavniMaterijalDTO> nastavniMaterijali) {
        this.id = id;
        this.naziv = naziv;
        this.nastavniMaterijali = nastavniMaterijali;
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

	public List<NastavniMaterijalDTO> getNastavniMaterijali() {
		return nastavniMaterijali;
	}

	public void setNastavniMaterijali(List<NastavniMaterijalDTO> nastavniMaterijali) {
		this.nastavniMaterijali = nastavniMaterijali;
	}

    

}