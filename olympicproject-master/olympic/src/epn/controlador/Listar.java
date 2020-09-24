package epn.controlador;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import epn.modelo.Deportista;

/**
 * @author Miguel Reina - Alisson Sanmartín - Edison Almeida
 * Servlet implementation class Listar
 */

@Transactional
@WebServlet("/Listar")
public class Listar extends HttpServlet{
	private static final long serialVersionUID =1L;
	@PersistenceContext(unitName="olympicPU")
	private EntityManager em;
	public Listar() {
		super();
	}
	/**
     * doGet que sirve para listar datos
     * @param request - 
     * @param respone - 
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Query q = em.createQuery("SELECT d FROM Deportista AS d", Deportista.class);
		@SuppressWarnings("unchecked")
		List<Deportista> dep = q.getResultList();
		req.setAttribute("dep", dep);
		req.getRequestDispatcher("listar.jsp").forward(req, resp);
	}
	@Override
	 /**

     * Método doPost perimite mostrar la lista de los deportistas

     */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}