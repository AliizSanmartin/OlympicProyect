package epn.controlador;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epn.modelo.DeportistaPatinaje;

/**
 * @author Miguel Reina - Alisson Sanmartín - Edison Almeida
 * Servlet implementation class EditarPatinador
 */
@WebServlet("/EditarPatinador")
public class EditarPatinador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@PersistenceContext(unitName = "olympicPU")
	private EntityManager em;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		DeportistaPatinaje d = em.find(DeportistaPatinaje.class, Integer.parseInt(id));
		request.setAttribute("dep", d);
		request.getRequestDispatcher("editarPatinador.jsp").forward(request, response);
	}
	 /**

     * Método que realiza el doPost en la Servlet

     */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
