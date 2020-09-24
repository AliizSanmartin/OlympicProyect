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

import epn.modelo.DeportistaAtletismo;

/**
 * @author Miguel Reina - Alisson Sanmartín - Edison Almeida
 * Servlet implementation class ListarAtletismo
 */
@WebServlet("/ListarAtletismo")
public class ListarAtletismo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="olympicPU")
	private EntityManager em;

    public ListarAtletismo() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Query q = em.createQuery("SELECT d FROM DeportistaAtletismo AS d", DeportistaAtletismo.class);
		@SuppressWarnings("unchecked")
		List<DeportistaAtletismo> dep = q.getResultList();
		request.setAttribute("dep", dep);
		request.getRequestDispatcher("listarAtletismo.jsp").forward(request, response);
	}
	 /**

     * Método doPost de mostrar la diciplina de atletismo

     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
