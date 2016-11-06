package si.fri.prpo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import si.fri.prpo.entitete.Entity;
import si.fri.prpo.entitete.Uporabnik;

public class UporabnikDaoImpl implements BaseDao {

	private String sql = "";
	
	@Override
	public Connection getConnection() {
		Connection conn = null;
		Context initCtx = null;
		DataSource ds = null;
		try {
			initCtx = new InitialContext();
			ds = (DataSource) initCtx.lookup("java:/PostgresDS");
			conn = ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		} 
		
		return conn;
	}

	@Override
	public Entity vrni(int id) {

		Entity entity = null;
		sql = "SELECT * FROM public.\"Uporabnik\" WHERE id = ?";
		try (Connection conn = getConnection()) {
			System.out.println(conn);
			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				
				ps.setInt(1, id);
				
				try (ResultSet rs = ps.executeQuery()) {
					
					while (rs.next()) {
						entity = new Uporabnik(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6));
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return entity;
	}

	@Override
	public void vstavi(Entity entity) {
		
		sql = "INSERT INTO public.\"Uporabnik\" (id, ime, priimek, naslov, email, rojstvo) VALUES (?, ?, ?, ?, ?, ?)";
		
		try (Connection conn = getConnection()) {
			
			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setInt(1, ((Uporabnik)entity).getId());
				ps.setString(2, ((Uporabnik)entity).getIme());
				ps.setString(3, ((Uporabnik)entity).getPriimek());
				ps.setString(4, ((Uporabnik)entity).getNaslov());
				ps.setString(5, ((Uporabnik)entity).getEmail());
				ps.setDate(6, ((Uporabnik)entity).getRojstvo());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void odstrani(int id) {
		
		sql = "DELETE FROM public.\"Uporabnik\" WHERE id=?";
		
		try (Connection conn = getConnection()) {
			
			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				
				ps.setInt(1, id);
				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void posodobi(Entity entity) {
		
		sql = "UPDATE public.\"Uporabnik\" SET id=?, ime=?, priimek=?, rojstvo=?, naslov=?, email=? WHERE id=?";
		
		try (Connection conn = getConnection()) {
			
			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				
				ps.setInt(1, ((Uporabnik)entity).getId());
				ps.setString(2, ((Uporabnik)entity).getIme());
				ps.setString(3, ((Uporabnik)entity).getPriimek());
				ps.setString(4, ((Uporabnik)entity).getNaslov());
				ps.setString(5, ((Uporabnik)entity).getEmail());
				ps.setDate(6, (java.sql.Date) ((Uporabnik)entity).getRojstvo());
				ps.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Entity> vrniVse() {
		
		List<Entity> list = new LinkedList<Entity>();
		sql = "SELECT * FROM public.\"Uporabnik\" ";
		
		try (Connection conn = getConnection()) {
			
			try (PreparedStatement ps = conn.prepareStatement(sql)) {
				
				try (ResultSet rs = ps.executeQuery()) {
					
					while (rs.next()) {
						list.add(new Uporabnik(rs.getInt(1) ,rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6)));
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
