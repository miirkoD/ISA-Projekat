package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.time.LocalDateTime;

public class AdministrativnoAngazovanjeDTO {

    private Long id;
    private LocalDateTime pocetak;
    private LocalDateTime kraj;
    private NastavnikDTO nastavnik;
    private StudijskiProgramDTO studijskiProgram;
    private FakultetDTO fakultet;

    public AdministrativnoAngazovanjeDTO() {}

    public AdministrativnoAngazovanjeDTO(Long id, LocalDateTime pocetak, LocalDateTime kraj) {
        this.id = id;
        this.pocetak = pocetak;
        this.kraj = kraj;
    }

    public AdministrativnoAngazovanjeDTO(Long id, LocalDateTime pocetak, LocalDateTime kraj, NastavnikDTO nastavnik, StudijskiProgramDTO studijskiProgram, FakultetDTO fakultet) {
        this.id = id;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.nastavnik = nastavnik;
        this.studijskiProgram = studijskiProgram;
        this.fakultet = fakultet;
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

	public NastavnikDTO getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(NastavnikDTO nastavnik) {
		this.nastavnik = nastavnik;
	}

	public StudijskiProgramDTO getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgramDTO studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}

	public FakultetDTO getFakultet() {
		return fakultet;
	}

	public void setFakultet(FakultetDTO fakultet) {
		this.fakultet = fakultet;
	}

    

}
