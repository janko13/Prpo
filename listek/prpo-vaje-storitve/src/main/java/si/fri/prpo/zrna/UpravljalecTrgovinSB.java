package si.fri.prpo.zrna;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import entitete.Trgovina;
import si.fri.prpo.zrna.UpravljalecTrgovinSBLocal;
import si.fri.prpo.zrna.UpravljalecTrgovinSBRemote;

/**
 * Session Bean implementation class UpravljalecTrgovinSB
 */
@Stateless
@LocalBean
public class UpravljalecTrgovinSB implements UpravljalecTrgovinSBLocal, UpravljalecTrgovinSBRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UpravljalecTrgovinSB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Trgovina vrniTrgovino(int id) {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Trgovina> cq = cb.createQuery(Trgovina.class);
		Root<Trgovina> trgovina = cq.from(Trgovina.class);
		cq.select(trgovina).where(cb.equal(trgovina.get("id"), id));
		Trgovina t = em.createQuery(cq).getSingleResult();
		
		return t;
	}

}
