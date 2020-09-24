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

import epn.modelo.DeportistaPatinaje;

/**
 * @author Miguel Reina - Alisson Sanmartín - Edison Almeida
 * Servlet implementation class ListarPatinaje
 */
@WebServlet("/ListarPatinaje")
public class ListarPatinaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName="olympicPU")
	private EntityManager em;
	
    public ListarPatinaje() {
        super();
    }
	 /**

     * Método doGet con el Query para listar patinadres

     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Query q = em.createQuery("SELECT d FROM DeportistaPatinaje AS d", DeportistaPatinaje.class);
		List<DeportistaPatinaje> dep = q.getResultList();
		request.setAttribute("dep", dep);
		request.getRequestDispatcher("listarPatinaje.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
