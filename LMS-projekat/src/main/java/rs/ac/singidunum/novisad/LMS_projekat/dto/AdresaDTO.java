package rs.ac.singidunum.novisad.LMS_projekat.dto;

public class AdresaDTO {

    private Long id;
    private String ulica;
    private String broj;
    private MestoDTO mesto;

    public AdresaDTO() {}


    public AdresaDTO(Long id, String ulica, String broj) {
        this.id = id;
        this.ulica = ulica;
        this.broj = broj;
    }

    public AdresaDTO(Long id, String ulica, String broj, MestoDTO mesto) {
        this.id = id;
        this.ulica = ulica;
        this.broj = broj;
        this.mesto = mesto;
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUlica() {
		return ulica;
	}


	public void setUlica(String ulica) {
		this.ulica = ulica;
	}


	public String getBroj() {
		return broj;
	}


	public void setBroj(String broj) {
		this.broj = broj;
	}


	public MestoDTO getMesto() {
		return mesto;
	}


	public void setMesto(MestoDTO mesto) {
		this.mesto = mesto;
	}



}
