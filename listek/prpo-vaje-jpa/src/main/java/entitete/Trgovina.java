package entitete;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Trgovina" database table.
 * 
 */
@Entity
@Table(name="\"Trgovina\"")
@NamedQuery(name="Trgovina.findAll", query="SELECT t FROM Trgovina t")
public class Trgovina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String lokacija;

	private String naziv;

	//bi-directional many-to-one association to TrgovinaIzdelek
	@OneToMany(mappedBy="trgovina")
	private List<TrgovinaIzdelek> trgovinaIzdeleks;

	public Trgovina() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLokacija() {
		return this.lokacija;
	}

	public void setLokacija(String lokacija) {
		this.lokacija = lokacija;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<TrgovinaIzdelek> getTrgovinaIzdeleks() {
		return this.trgovinaIzdeleks;
	}

	public void setTrgovinaIzdeleks(List<TrgovinaIzdelek> trgovinaIzdeleks) {
		this.trgovinaIzdeleks = trgovinaIzdeleks;
	}

	public TrgovinaIzdelek addTrgovinaIzdelek(TrgovinaIzdelek trgovinaIzdelek) {
		getTrgovinaIzdeleks().add(trgovinaIzdelek);
		trgovinaIzdelek.setTrgovina(this);

		return trgovinaIzdelek;
	}

	public TrgovinaIzdelek removeTrgovinaIzdelek(TrgovinaIzdelek trgovinaIzdelek) {
		getTrgovinaIzdeleks().remove(trgovinaIzdelek);
		trgovinaIzdelek.setTrgovina(null);

		return trgovinaIzdelek;
	}

}