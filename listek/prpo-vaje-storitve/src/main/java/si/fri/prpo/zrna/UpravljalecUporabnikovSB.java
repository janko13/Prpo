package si.fri.prpo.zrna;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import entitete.Listek;
import entitete.ListekIzdelek;
import entitete.Uporabnik;
import si.fri.prpo.zrna.UpravljalecUporabnikovSBLocal;
import si.fri.prpo.zrna.UpravljalecUporabnikovSBRemote;

/**
 * Session Bean implementation class UpravljalecUporabnkovSB
 */
@Stateless
@LocalBean
public class UpravljalecUporabnikovSB implements UpravljalecUporabnikovSBLocal, UpravljalecUporabnikovSBRemote {

	@PersistenceContext
    EntityManager em;
	
	
    /**
     * Default constructor. 
     */
    public UpravljalecUporabnikovSB() {
    	
    }

	@Override
	public void dodajUporabnika(Uporabnik uporabnik) {
		em.persist(uporabnik);
	}

	@Override
	public void zbrisiUporabnika(int id) {
		
		Uporabnik uporabnik = vrniUporabnika(id);
		
		List<Listek> listki = em.createQuery("SELECT l FROM public.Listek l WHERE l.user_id = :user_id").setParameter("user_id", id).getResultList();
		
		for (Listek listek : listki) {
			zbrisiIzdelkeIzListka(listek.getId());
			em.remove(listek);
		}
		
		em.remove(uporabnik);
		
	}
	
	private void zbrisiIzdelkeIzListka(long listek_id) {
		
		List<ListekIzdelek> izdelki = (List<ListekIzdelek>) em.createQuery("SELECT l FROM public.ListekIzdelek l WHERE l.listek_id = :listek_id")
				.setParameter("listek_id", listek_id);
		for (ListekIzdelek listekIzdelek : izdelki) {
			em.remove(listekIzdelek);
		}
	}

	@Override
	public Uporabnik vrniUporabnika(int id) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Uporabnik> cq = cb.createQuery(Uporabnik.class);
		Root<Uporabnik> uporabnik = cq.from(Uporabnik.class);
		cq.select(uporabnik).where(cb.equal(uporabnik.get("id"), id));
		Uporabnik u = em.createQuery(cq).getSingleResult();
		
		return u;
	}

	@Override
	public List<Uporabnik> vrniVse() {
		
		return (List<Uporabnik>) em.createNamedQuery("Uporabnik.findAll").getResultList();
	}

}
