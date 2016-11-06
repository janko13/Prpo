package entitete;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "TrgovinaIzdelek" database table.
 * 
 */
@Entity
@Table(name="\"TrgovinaIzdelek\"")
@NamedQuery(name="TrgovinaIzdelek.findAll", query="SELECT t FROM TrgovinaIzdelek t")
public class TrgovinaIzdelek implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	//bi-directional many-to-one association to Izdelek
	@ManyToOne
	private Izdelek izdelek;

	//bi-directional many-to-one association to Trgovina
	@ManyToOne
	private Trgovina trgovina;

	public TrgovinaIzdelek() {
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

	public Trgovina getTrgovina() {
		return this.trgovina;
	}

	public void setTrgovina(Trgovina trgovina) {
		this.trgovina = trgovina;
	}

}