package rs.ac.singidunum.novisad.LMS_projekat.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SkolskaGodinaDTO {

    private Long id;
    private LocalDate pocetak;
    private LocalDate kraj;
    private GodinaStudijaDTO godinaStudija;
    private List<RealizacijaPredmetaDTO> realizacijaPredmeta = new ArrayList<>();
    private List<UpisDTO> upisi = new ArrayList<>();

    public SkolskaGodinaDTO() {}

    public SkolskaGodinaDTO(Long id, LocalDate pocetak, LocalDate kraj) {
        this.id = id;
        this.pocetak = pocetak;
        this.kraj = kraj;
    }

    public SkolskaGodinaDTO(Long id, LocalDate pocetak, LocalDate kraj, GodinaStudijaDTO godinaStudija) {
        this.id = id;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.godinaStudija = godinaStudija;
    }

    public SkolskaGodinaDTO(Long id, LocalDate pocetak, LocalDate kraj, GodinaStudijaDTO godinaStudija, List<RealizacijaPredmetaDTO> realizacijaPredmeta, List<UpisDTO> upisi) {
        this.id = id;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.godinaStudija = godinaStudija;
        this.realizacijaPredmeta = realizacijaPredmeta;
        this.upisi = upisi;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getPocetak() {
		return pocetak;
	}

	public void setPocetak(LocalDate pocetak) {
		this.pocetak = pocetak;
	}

	public LocalDate getKraj() {
		return kraj;
	}

	public void setKraj(LocalDate kraj) {
		this.kraj = kraj;
	}

	public GodinaStudijaDTO getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudijaDTO godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public List<RealizacijaPredmetaDTO> getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(List<RealizacijaPredmetaDTO> realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public List<UpisDTO> getUpisi() {
		return upisi;
	}

	public void setUpisi(List<UpisDTO> upisi) {
		this.upisi = upisi;
	}

   

}
