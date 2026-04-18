package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TerminNastaveDTO {

    private Long id;
    private LocalDateTime pocetak;
    private LocalDateTime kraj;
    private TipNastaveDTO tipNastave;
    private NastavniMaterijalDTO nastavniMaterijal;
    private RealizacijaPredmetaDTO realizacijaPredmeta;
    private List<AngazovanjeDTO> angazovanja = new ArrayList<>();

    public TerminNastaveDTO() {}

    public TerminNastaveDTO(Long id, LocalDateTime pocetak, LocalDateTime kraj) {
        this.id = id;
        this.pocetak = pocetak;
        this.kraj = kraj;
    }

    public TerminNastaveDTO(Long id, LocalDateTime pocetak, LocalDateTime kraj, TipNastaveDTO tipNastave, NastavniMaterijalDTO nastavniMaterijal, RealizacijaPredmetaDTO realizacijaPredmeta) {
        this.id = id;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.tipNastave = tipNastave;
        this.nastavniMaterijal = nastavniMaterijal;
        this.realizacijaPredmeta = realizacijaPredmeta;
    }

    public TerminNastaveDTO(Long id, LocalDateTime pocetak, LocalDateTime kraj, TipNastaveDTO tipNastave, NastavniMaterijalDTO nastavniMaterijal, RealizacijaPredmetaDTO realizacijaPredmeta, List<AngazovanjeDTO> angazovanja) {
        this.id = id;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.tipNastave = tipNastave;
        this.nastavniMaterijal = nastavniMaterijal;
        this.realizacijaPredmeta = realizacijaPredmeta;
        this.angazovanja = angazovanja;
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

	public TipNastaveDTO getTipNastave() {
		return tipNastave;
	}

	public void setTipNastave(TipNastaveDTO tipNastave) {
		this.tipNastave = tipNastave;
	}

	public NastavniMaterijalDTO getNastavniMaterijal() {
		return nastavniMaterijal;
	}

	public void setNastavniMaterijal(NastavniMaterijalDTO nastavniMaterijal) {
		this.nastavniMaterijal = nastavniMaterijal;
	}

	public RealizacijaPredmetaDTO getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmetaDTO realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public List<AngazovanjeDTO> getAngazovanja() {
		return angazovanja;
	}

	public void setAngazovanja(List<AngazovanjeDTO> angazovanja) {
		this.angazovanja = angazovanja;
	}

    

}