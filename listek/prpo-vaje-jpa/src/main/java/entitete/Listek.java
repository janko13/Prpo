package entitete;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Listek" database table.
 * 
 */
@Entity
@Table(name="\"Listek\"")
@NamedQuery(name="Listek.findAll", query="SELECT l FROM Listek l")
public class Listek implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	//bi-directional many-to-one association to Uporabnik
	@ManyToOne
	@JoinColumn(name="user_id")
	private Uporabnik uporabnik;

	//bi-directional many-to-one association to ListekIzdelek
	@OneToMany(mappedBy="listek")
	private List<ListekIzdelek> listekIzdeleks;

	public Listek() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Uporabnik getUporabnik() {
		return this.uporabnik;
	}

	public void setUporabnik(Uporabnik uporabnik) {
		this.uporabnik = uporabnik;
	}

	public List<ListekIzdelek> getListekIzdeleks() {
		return this.listekIzdeleks;
	}

	public void setListekIzdeleks(List<ListekIzdelek> listekIzdeleks) {
		this.listekIzdeleks = listekIzdeleks;
	}

	public ListekIzdelek addListekIzdelek(ListekIzdelek listekIzdelek) {
		getListekIzdeleks().add(listekIzdelek);
		listekIzdelek.setListek(this);

		return listekIzdelek;
	}

	public ListekIzdelek removeListekIzdelek(ListekIzdelek listekIzdelek) {
		getListekIzdeleks().remove(listekIzdelek);
		listekIzdelek.setListek(null);

		return listekIzdelek;
	}

}