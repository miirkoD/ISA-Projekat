package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.util.ArrayList;
import java.util.List;

public class NastavniMaterijalDTO {

    private Long id;
    private String naziv;
    private String opis;
    private TipNastavnogMaterijalaDTO tipNastavnogMaterijala;
    private InstrumentEvaluacijeZnanjaDTO instrumentEvaluacijeZnanja;
    private RealizacijaPredmetaDTO realizacijaPredmeta;
    private List<DatotekaDTO> datoteke = new ArrayList<>();
    private List<TerminNastaveDTO> terminiNastave = new ArrayList<>();

    public NastavniMaterijalDTO() {}

    public NastavniMaterijalDTO(Long id, String naziv, String opis) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
    }

    public NastavniMaterijalDTO(Long id, String naziv, String opis, TipNastavnogMaterijalaDTO tipNastavnogMaterijala, InstrumentEvaluacijeZnanjaDTO instrumentEvaluacijeZnanja, RealizacijaPredmetaDTO realizacijaPredmeta) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tipNastavnogMaterijala = tipNastavnogMaterijala;
        this.instrumentEvaluacijeZnanja = instrumentEvaluacijeZnanja;
        this.realizacijaPredmeta = realizacijaPredmeta;
    }
    
	  public NastavniMaterijalDTO(Long id, String naziv, String opis, TipNastavnogMaterijalaDTO tipNastavnogMaterijala, InstrumentEvaluacijeZnanjaDTO instrumentEvaluacijeZnanja, RealizacijaPredmetaDTO realizacijaPredmeta, List<DatotekaDTO> datoteke, List<TerminNastaveDTO> terminiNastave) {
	  this.id = id;
	  this.naziv = naziv;
	  this.opis = opis;
	  this.tipNastavnogMaterijala = tipNastavnogMaterijala;
	  this.instrumentEvaluacijeZnanja = instrumentEvaluacijeZnanja;
	  this.realizacijaPredmeta = realizacijaPredmeta;
	  this.datoteke = datoteke;
	  this.terminiNastave = terminiNastave;
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

	public TipNastavnogMaterijalaDTO getTipNastavnogMaterijala() {
		return tipNastavnogMaterijala;
	}

	public void setTipNastavnogMaterijala(TipNastavnogMaterijalaDTO tipNastavnogMaterijala) {
		this.tipNastavnogMaterijala = tipNastavnogMaterijala;
	}

	public InstrumentEvaluacijeZnanjaDTO getInstrumentEvaluacijeZnanja() {
		return instrumentEvaluacijeZnanja;
	}

	public void setInstrumentEvaluacijeZnanja(InstrumentEvaluacijeZnanjaDTO instrumentEvaluacijeZnanja) {
		this.instrumentEvaluacijeZnanja = instrumentEvaluacijeZnanja;
	}

	public RealizacijaPredmetaDTO getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmetaDTO realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public List<TerminNastaveDTO> getTerminiNastave() {
		return terminiNastave;
	}

	public void setTerminiNastave(List<TerminNastaveDTO> terminiNastave) {
		this.terminiNastave = terminiNastave;
	}

	public List<DatotekaDTO> getDatoteke() {
		return datoteke;
	}

	public void setDatoteke(List<DatotekaDTO> datoteke) {
		this.datoteke = datoteke;
	}



    

}