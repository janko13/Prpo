package entitete;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "ListekIzdelek" database table.
 * 
 */
@Entity
@Table(name="\"ListekIzdelek\"")
@NamedQuery(name="ListekIzdelek.findAll", query="SELECT l FROM ListekIzdelek l")
public class ListekIzdelek implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	//bi-directional many-to-one association to Izdelek
	@ManyToOne
	private Izdelek izdelek;

	//bi-directional many-to-one association to Listek
	@ManyToOne
	private Listek listek;

	public ListekIzdelek() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Izdelek getIzdelek() {
		return this.izdelek;
	}

	public void setIzdelek(Izdelek izdelek) {
		this.izdelek = izdelek;
	}

	public Listek getListek() {
		return this.listek;
	}

	public void setListek(Listek listek) {
		this.listek = listek;
	}

}