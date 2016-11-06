package entitete;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Izdelek" database table.
 * 
 */
@Entity
@Table(name="\"Izdelek\"")
@NamedQuery(name="Izdelek.findAll", query="SELECT i FROM Izdelek i")
public class Izdelek implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private double cena;

	private String kategorija;

	private String naziv;

	//bi-directional many-to-one association to ListekIzdelek
	@OneToMany(mappedBy="izdelek")
	private List<ListekIzdelek> listekIzdeleks;

	//bi-directional many-to-one association to TrgovinaIzdelek
	@OneToMany(mappedBy="izdelek")
	private List<TrgovinaIzdelek> trgovinaIzdeleks;

	public Izdelek() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getKategorija() {
		return this.kategorija;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<ListekIzdelek> getListekIzdeleks() {
		return this.listekIzdeleks;
	}

	public void setListekIzdeleks(List<ListekIzdelek> listekIzdeleks) {
		this.listekIzdeleks = listekIzdeleks;
	}

	public ListekIzdelek addListekIzdelek(ListekIzdelek listekIzdelek) {
		getListekIzdeleks().add(listekIzdelek);
		listekIzdelek.setIzdelek(this);

		return listekIzdelek;
	}

	public ListekIzdelek removeListekIzdelek(ListekIzdelek listekIzdelek) {
		getListekIzdeleks().remove(listekIzdelek);
		listekIzdelek.setIzdelek(null);

		return listekIzdelek;
	}

	public List<TrgovinaIzdelek> getTrgovinaIzdeleks() {
		return this.trgovinaIzdeleks;
	}

	public void setTrgovinaIzdeleks(List<TrgovinaIzdelek> trgovinaIzdeleks) {
		this.trgovinaIzdeleks = trgovinaIzdeleks;
	}

	public TrgovinaIzdelek addTrgovinaIzdelek(TrgovinaIzdelek trgovinaIzdelek) {
		getTrgovinaIzdeleks().add(trgovinaIzdelek);
		trgovinaIzdelek.setIzdelek(this);

		return trgovinaIzdelek;
	}

	public TrgovinaIzdelek removeTrgovinaIzdelek(TrgovinaIzdelek trgovinaIzdelek) {
		getTrgovinaIzdeleks().remove(trgovinaIzdelek);
		trgovinaIzdelek.setIzdelek(null);

		return trgovinaIzdelek;
	}

}