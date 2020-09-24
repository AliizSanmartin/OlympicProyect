package epn.controlador;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import epn.modelo.Deportista;

/**
 * @author Miguel Reina - Alisson Sanmartín - Edison Almeida
 * Servlet implementation class Editar
 */

@Transactional
@WebServlet("/Editar")
public class Editar extends HttpServlet{

	private static final long serialVersionUID =1L;
	
	@PersistenceContext(unitName="olympicPU")
	private EntityManager em;
	
	public Editar() {
		
		super();
		
	}
	/**
     * doGet que sirve para editar datos
     * @param request - 
     * @param respone - 
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		Deportista d = em.find(Deportista.class, Integer.parseInt(id));
		req.setAttribute("dep", d);
		req.getRequestDispatcher("editar.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
		
	}	
	
}
