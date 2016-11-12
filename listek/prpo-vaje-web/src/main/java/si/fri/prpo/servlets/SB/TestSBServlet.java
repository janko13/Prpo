package si.fri.prpo.servlets.SB;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import entitete.Listek;
import entitete.Trgovina;
import entitete.Uporabnik;
import si.fri.prpo.zrna.UpravljalecListkovSBLocal;
import si.fri.prpo.zrna.UpravljalecTrgovinSBLocal;
import si.fri.prpo.zrna.UpravljalecUporabnikovSBLocal;

/**
 * Servlet implementation class TestSBServlet
 */
public class TestSBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@PersistenceContext
	EntityManager em;
	
	@EJB
	UpravljalecUporabnikovSBLocal upravljalecUporabnikov;
	@EJB
	UpravljalecTrgovinSBLocal upravljalecTrgovin;
	@EJB
	UpravljalecListkovSBLocal upravljalecListkov;
	
    public TestSBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		
		List<Uporabnik> uporabniki = upravljalecUporabnikov.vrniVse();
		out.println("<br> Uporabniki </br>");
		for (Uporabnik u : uporabniki) {
			out.println("<br>" + u.toString());
		}
		
		Uporabnik up = upravljalecUporabnikov.vrniUporabnika(1);
		out.println("<br>" + up.toString());
		
		
		//upravljalecListkov.zbrisiListek(3);
		//upravljalecUporabnikov.zbrisiUporabnika(1);
		/*try {
			upravljalecUporabnikov.zbrisiUporabnika(1);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		Uporabnik add = new Uporabnik();
		//add.setId((long) 9);
		add.setIme("Rok");
		add.setPriimek("Oblak");
		add.setNaslov("cesta 12");
		add.setEmail("ro@gmail.com");
		add.setRojstvo(new java.sql.Date(new java.util.Date().getDate()));
		upravljalecUporabnikov.dodajUporabnika(add);
		
		
		out.println("\n");
		
		/*List<Listek> listki = upravljalecListkov.vrniVse();
		for (Listek l : listki) {
			out.println("<br>" + l.toString());
		}*/
		/*Trgovina trgovina = upravljalecTrgovin.vrniTrgovino(1);
		
		Listek listek = new Listek();
		listek.setId(50L);
		listek.setUporabnik(up);
		upravljalecListkov.dodajListek(listek);*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
