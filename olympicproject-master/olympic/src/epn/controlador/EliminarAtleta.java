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

import epn.modelo.DeportistaAtletismo;

/**
 * @author Miguel Reina - Alisson Sanmartín - Edison Almeida
 * Servlet implementation class Eliminar Atleta
 */
@Transactional
@WebServlet("/EliminarAtleta")
public class EliminarAtleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="olympicPU")
	private EntityManager em;
	
       
    public EliminarAtleta() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		DeportistaAtletismo d = em.find(DeportistaAtletismo.class, Integer.parseInt(id));
		em.remove(d);
		
		request.getRequestDispatcher("ListarAtletismo").forward(request, response);
	}

	 /**

     * Método doPost de Elimacion de un Atleta

     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
