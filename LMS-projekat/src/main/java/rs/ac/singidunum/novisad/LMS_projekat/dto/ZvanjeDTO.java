package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.time.LocalDateTime;

public class ZvanjeDTO {

    private Long id;
    private LocalDateTime datumIzbora;
    private LocalDateTime datumPrestanka;
    private NastavnikDTO nastavnik;
    private TipZvanjaDTO tipZvanja;
    private NaucnaOblastDTO naucnaOblast;

    public ZvanjeDTO() {}

    public ZvanjeDTO(Long id, LocalDateTime datumIzbora, LocalDateTime datumPrestanka) {
        this.id = id;
        this.datumIzbora = datumIzbora;
        this.datumPrestanka = datumPrestanka;
    }

    public ZvanjeDTO(Long id, LocalDateTime datumIzbora, LocalDateTime datumPrestanka, NastavnikDTO nastavnik, TipZvanjaDTO tipZvanja, NaucnaOblastDTO naucnaOblast) {
        this.id = id;
        this.datumIzbora = datumIzbora;
        this.datumPrestanka = datumPrestanka;
        this.nastavnik = nastavnik;
        this.tipZvanja = tipZvanja;
        this.naucnaOblast = naucnaOblast;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDatumIzbora() {
		return datumIzbora;
	}

	public void setDatumIzbora(LocalDateTime datumIzbora) {
		this.datumIzbora = datumIzbora;
	}

	public LocalDateTime getDatumPrestanka() {
		return datumPrestanka;
	}

	public void setDatumPrestanka(LocalDateTime datumPrestanka) {
		this.datumPrestanka = datumPrestanka;
	}

	public NastavnikDTO getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(NastavnikDTO nastavnik) {
		this.nastavnik = nastavnik;
	}

	public TipZvanjaDTO getTipZvanja() {
		return tipZvanja;
	}

	public void setTipZvanja(TipZvanjaDTO tipZvanja) {
		this.tipZvanja = tipZvanja;
	}

	public NaucnaOblastDTO getNaucnaOblast() {
		return naucnaOblast;
	}

	public void setNaucnaOblast(NaucnaOblastDTO naucnaOblast) {
		this.naucnaOblast = naucnaOblast;
	}

    
}
