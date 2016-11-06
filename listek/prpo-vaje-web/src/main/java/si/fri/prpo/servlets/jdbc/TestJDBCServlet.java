package si.fri.prpo.servlets.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import si.fri.prpo.dao.UporabnikDaoImpl;
import si.fri.prpo.entitete.Entity;
import si.fri.prpo.entitete.Uporabnik;

/**
 * Servlet implementation class TestJDBCServlet
 */
public class TestJDBCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestJDBCServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Uporabniki</h1>");
		
		UporabnikDaoImpl uporDao = new UporabnikDaoImpl();
		List<Entity> uporabniki = uporDao.vrniVse();
		
		for (Entity e : uporabniki) {
			out.println("<br>" + ((Uporabnik)e).toString() + "</br>");
		}
		
		Uporabnik u = (Uporabnik) uporDao.vrni(1);
		out.println("<br>" + u.toString());
		
		Uporabnik nov = new Uporabnik(5, "Rok", "Oblak", "Slovenska 2", "ro@gmail.com", new java.sql.Date(new java.util.Date().getDate()));
		uporDao.vstavi((Entity)nov);
		
		uporabniki = uporDao.vrniVse();
		
		for (Entity e : uporabniki) {
			out.println("<br>" + ((Uporabnik)e).toString() + "</br>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
