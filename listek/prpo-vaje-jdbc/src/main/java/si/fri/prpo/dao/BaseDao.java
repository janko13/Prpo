package si.fri.prpo.dao;

import java.sql.Connection;
import java.util.List;

import si.fri.prpo.entitete.Entity;

public interface BaseDao {

	public Connection getConnection();
	public Entity vrni(int id);
	public void vstavi(Entity ent);
	public void odstrani(int id);
	public void posodobi(Entity ent);
	public List<Entity> vrniVse();
	
}
