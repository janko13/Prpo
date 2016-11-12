package si.fri.prpo.zrna;


import java.util.List;

import entitete.Uporabnik;

public abstract interface UpravljalecUporabnikovSBAbstract {

	public void dodajUporabnika(Uporabnik uporabnik);
	public void zbrisiUporabnika(int id);
	public List<Uporabnik> vrniVse();
	public Uporabnik vrniUporabnika(int id);
	
}
