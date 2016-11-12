package si.fri.prpo.zrna;

import java.util.List;

import entitete.Listek;

public abstract interface UpravljalecListkovSBAbstract {

	public void dodajListek(Listek listek);
	public void zbrisiListek(int id);
	public List<Listek> vrniVse();
}
