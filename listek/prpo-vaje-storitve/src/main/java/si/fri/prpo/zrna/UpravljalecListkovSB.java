package si.fri.prpo.zrna;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import entitete.Listek;
import si.fri.prpo.zrna.UpravljalecListkovSBLocal;
import si.fri.prpo.zrna.UpravljalecListkovSBRemote;

/**
 * Session Bean implementation class UpravljalecListkovSB
 */
@Stateless
public class UpravljalecListkovSB implements UpravljalecListkovSBRemote, UpravljalecListkovSBLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UpravljalecListkovSB() {
    	
    }

	@Override
	public void dodajListek(Listek listek) {
		em.persist(listek);
	}

	@Override
	public void zbrisiListek(int id) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Listek> cq = cb.createQuery(Listek.class);
		Root<Listek> listek = cq.from(Listek.class);
		cq.select(listek).where(cb.equal(listek.get("id"), id));
		Listek l = em.createQuery(cq).getSingleResult();
		
		em.remove(l);
	}

	@Override
	public List<Listek> vrniVse() {
		
		return (List<Listek>)em.createNamedQuery("Listek.findAll").getResultList();
	}

}
