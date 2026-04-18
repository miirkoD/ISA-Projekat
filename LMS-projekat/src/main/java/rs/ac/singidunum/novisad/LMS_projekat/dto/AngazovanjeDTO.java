package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.time.LocalDateTime;

public class AngazovanjeDTO {

    private Long id;
    private LocalDateTime pocetak;
    private LocalDateTime kraj;
    private TipAngazovanjaDTO tipAngazovanja;
    private NastavnikDTO nastavnik;
    private TerminNastaveDTO terminNastave;
    private RealizacijaPredmetaDTO realizacijaPredmeta;

    public AngazovanjeDTO() {}

    public AngazovanjeDTO(Long id, LocalDateTime pocetak, LocalDateTime kraj) {
        this.id = id;
        this.pocetak = pocetak;
        this.kraj = kraj;
    }

  public AngazovanjeDTO(Long id, LocalDateTime pocetak, LocalDateTime kraj, TipAngazovanjaDTO tipAngazovanja, NastavnikDTO nastavnik, TerminNastaveDTO terminNastave, RealizacijaPredmetaDTO realizacijaPredmeta) {
      this.id = id;
      this.pocetak = pocetak;
      this.kraj = kraj;
      this.tipAngazovanja = tipAngazovanja;
      this.nastavnik = nastavnik;
      this.terminNastave = terminNastave;
      this.realizacijaPredmeta = realizacijaPredmeta;
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

	public TipAngazovanjaDTO getTipAngazovanja() {
		return tipAngazovanja;
	}

	public void setTipAngazovanja(TipAngazovanjaDTO tipAngazovanja) {
		this.tipAngazovanja = tipAngazovanja;
	}

	public TerminNastaveDTO getTerminNastave() {
		return terminNastave;
	}

	public void setTerminNastave(TerminNastaveDTO terminNastave) {
		this.terminNastave = terminNastave;
	}

	public RealizacijaPredmetaDTO getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmetaDTO realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public NastavnikDTO getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(NastavnikDTO nastavnik) {
		this.nastavnik = nastavnik;
	}

}