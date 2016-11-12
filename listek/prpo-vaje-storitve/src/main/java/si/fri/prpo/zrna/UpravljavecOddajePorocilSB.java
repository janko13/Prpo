package si.fri.prpo.zrna;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entitete.Uporabnik;

/**
 * Session Bean implementation class UpravljavecOddajePorocilSB
 */
@Stateless
public class UpravljavecOddajePorocilSB implements UpravljavecOddajePorocilSBRemote, UpravljavecOddajePorocilSBLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UpravljavecOddajePorocilSB() {
    	
    }

	@Override
	public List<Uporabnik> vrniUporabnike() {
		return (List<Uporabnik>)em.createNamedQuery("Uporabnik.findAll");
	}

}
