package si.fri.prpo.entitete;

import java.sql.Date;

public class Uporabnik extends Entity {

	private static final long serialVersionUID = 1L;
	
	private String ime;
	private String priimek;
	private String naslov;
	private String email;
	private Date rojstvo;
	
	public Uporabnik(Integer id, String ime, String priimek, String naslov, String email, Date rojstvo) {
		setId(id);
		this.ime = ime;
		this.priimek = priimek;
		this.email = email;
		this.naslov = naslov;
		this.rojstvo = rojstvo;
	}
	
	public String toString() {
		return getId() + " " + ime + " " + priimek + " " + naslov + " " + email + " " + rojstvo.toString();
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPriimek() {
		return priimek;
	}

	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRojstvo() {
		return rojstvo;
	}

	public void setRojstvo(Date rojstvo) {
		this.rojstvo = rojstvo;
	}
	
	
	
}
