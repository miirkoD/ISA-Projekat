package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EvaluacijaZnanjaDTO {

    private Long id;
    private LocalDateTime pocetak;
    private LocalDateTime kraj;
    private Integer bodovi;
    private TipEvaluacijeZnanjaDTO tipEvaluacijeZnanja;
    private InstrumentEvaluacijeZnanjaDTO instrumentEvaluacijeZnanja;
    private RealizacijaPredmetaDTO realizacijaPredmeta;
    private List<PolaganjeDTO> polaganja = new ArrayList<>();

    public EvaluacijaZnanjaDTO() {}

    public EvaluacijaZnanjaDTO(Long id, LocalDateTime pocetak, LocalDateTime kraj, Integer bodovi) {
        this.id = id;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.bodovi = bodovi;
    }

    public EvaluacijaZnanjaDTO(Long id, LocalDateTime pocetak, LocalDateTime kraj, Integer bodovi, TipEvaluacijeZnanjaDTO tipEvaluacijeZnanja, InstrumentEvaluacijeZnanjaDTO instrumentEvaluacijeZnanja, RealizacijaPredmetaDTO realizacijaPredmeta) {
        this.id = id;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.bodovi = bodovi;
        this.tipEvaluacijeZnanja = tipEvaluacijeZnanja;
        this.instrumentEvaluacijeZnanja = instrumentEvaluacijeZnanja;
        this.realizacijaPredmeta = realizacijaPredmeta;
    }

    public EvaluacijaZnanjaDTO(Long id, LocalDateTime pocetak, LocalDateTime kraj, Integer bodovi, TipEvaluacijeZnanjaDTO tipEvaluacijeZnanja, InstrumentEvaluacijeZnanjaDTO instrumentEvaluacijeZnanja, RealizacijaPredmetaDTO realizacijaPredmeta, List<PolaganjeDTO> polaganja) {
        this.id = id;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.bodovi = bodovi;
        this.tipEvaluacijeZnanja = tipEvaluacijeZnanja;
        this.instrumentEvaluacijeZnanja = instrumentEvaluacijeZnanja;
        this.realizacijaPredmeta = realizacijaPredmeta;
        this.polaganja = polaganja;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getPocetak() {
		return pocetak;
	}

	public void setPocetak(LocalDateTime pocetak) {
		this.pocetak = pocetak;
	}

	public LocalDateTime getKraj() {
		return kraj;
	}

	public void setKraj(LocalDateTime kraj) {
		this.kraj = kraj;
	}

	public Integer getBodovi() {
		return bodovi;
	}

	public void setBodovi(Integer bodovi) {
		this.bodovi = bodovi;
	}

	public TipEvaluacijeZnanjaDTO getTipEvaluacijeZnanja() {
		return tipEvaluacijeZnanja;
	}

	public void setTipEvaluacijeZnanja(TipEvaluacijeZnanjaDTO tipEvaluacijeZnanja) {
		this.tipEvaluacijeZnanja = tipEvaluacijeZnanja;
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

	public List<PolaganjeDTO> getPolaganja() {
		return polaganja;
	}

	public void setPolaganja(List<PolaganjeDTO> polaganja) {
		this.polaganja = polaganja;
	}


}