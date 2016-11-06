package si.prpo.fri.SB;

import entitete.Uporabnik;

public abstract interface UpravljalecUporabnikovSBAbstract {

	public void dodajUporabnika(Uporabnik uporabnik);
	public void zbrisiUporabnika(int id);
	public void prikaziListke(Uporabnik uporabnik);
	
}
