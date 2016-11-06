package entitete;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "Uporabnik" database table.
 * 
 */
@Entity
@Table(name="\"Uporabnik\"")
@NamedQuery(name="Uporabnik.findAll", query="SELECT u FROM Uporabnik u")
public class Uporabnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String email;

	private String ime;

	private String naslov;

	private String priimek;

	@Temporal(TemporalType.DATE)
	private Date rojstvo;

	//bi-directional many-to-one association to Listek
	@OneToMany(mappedBy="uporabnik")
	private List<Listek> listeks;

	public Uporabnik() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getNaslov() {
		return this.naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getPriimek() {
		return this.priimek;
	}

	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}

	public Date getRojstvo() {
		return this.rojstvo;
	}

	public void setRojstvo(Date rojstvo) {
		this.rojstvo = rojstvo;
	}

	public List<Listek> getListeks() {
		return this.listeks;
	}

	public void setListeks(List<Listek> listeks) {
		this.listeks = listeks;
	}

	public Listek addListek(Listek listek) {
		getListeks().add(listek);
		listek.setUporabnik(this);

		return listek;
	}

	public Listek removeListek(Listek listek) {
		getListeks().remove(listek);
		listek.setUporabnik(null);

		return listek;
	}

}