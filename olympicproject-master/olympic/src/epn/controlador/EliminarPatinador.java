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

import epn.modelo.DeportistaPatinaje;

/**
 * Servlet implementation class EliminarPatinador
 */
@Transactional
@WebServlet("/EliminarPatinador")
public class EliminarPatinador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@PersistenceContext(unitName="olympicPU")
	private EntityManager em;
	
    public EliminarPatinador() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		DeportistaPatinaje d = em.find(DeportistaPatinaje.class, Integer.parseInt(id));
		em.remove(d);
		
		request.getRequestDispatcher("ListarPatinaje").forward(request, response);
	}

	 /**

     * Método doPost de Elimacion de un patinador

     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
