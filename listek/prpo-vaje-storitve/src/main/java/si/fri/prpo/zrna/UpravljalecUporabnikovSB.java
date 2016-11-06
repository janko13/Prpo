package si.fri.prpo.zrna;

import javax.ejb.Stateless;

import entitete.Uporabnik;
import si.prpo.fri.SB.UpravljalecUporabnikovSBLocal;
import si.prpo.fri.SB.UpravljalecUporabnikovSBRemote;

/**
 * Session Bean implementation class UpravljalecUporabnikovSB
 */
@Stateless
public class UpravljalecUporabnikovSB implements UpravljalecUporabnikovSBRemote, UpravljalecUporabnikovSBLocal {

    /**
     * Default constructor. 
     */
    public UpravljalecUporabnikovSB() {
    }

	@Override
	public void dodajUporabnika(Uporabnik uporabnik) {
		
	}

	@Override
	public void zbrisiUporabnika(int id) {
		
	}

	@Override
	public void prikaziListke(Uporabnik uporabnik) {
		
	}


}
