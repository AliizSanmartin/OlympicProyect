package epn.controlador;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epn.modelo.DeportistaAtletismo;

/**
 * @author Miguel Reina - Alisson Sanmartín - Edison Almeida
 * Servlet implementation class EditarAtleta
 */
@WebServlet("/EditarAtleta")
public class EditarAtleta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "olympicPU")
	private EntityManager em;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		DeportistaAtletismo d = em.find(DeportistaAtletismo.class, Integer.parseInt(id));
		request.setAttribute("dep", d);
		request.getRequestDispatcher("editarAtleta.jsp").forward(request, response);
	}
	 /**

     * Método qprotected para genereacion del doGet

     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
