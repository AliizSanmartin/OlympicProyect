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
 * @author Miguel Reina - Alisson Sanmart�n - Edison Almeida
 * Servlet implementation class RegistroAtleta
 */

@Transactional
@WebServlet("/RegistroAtleta")
public class RegistroAtleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@PersistenceContext(unitName="olympicPU")
	private EntityManager em;
	 /**

     * M�todo doGet para registro de un atleta

     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String medalla = request.getParameter("medalla");
		String fecha = request.getParameter("fecha");
		System.out.println("Datos del medallista -> Nombre: " + nombre + " Tipo de medalla: " + medalla + " Fecha: " + fecha );
		
		if (nombre.trim().equals("") || medalla.trim().equals("")) {
			request.setAttribute("valNombre", nombre);
			request.setAttribute("valMedalla", medalla);
			request.setAttribute("valFecha", fecha);
			request.setAttribute("valError", "Datos incorrectos o incompletos");
			request.getRequestDispatcher("registroAtleta.jsp").forward(request, response);
		}
		else {
			DeportistaAtletismo d = new DeportistaAtletismo();
			d.setNombre(nombre);
			d.setMedalla(medalla);
			d.setFecha(fecha);
			em.persist(d);
			request.getRequestDispatcher("ListarAtletismo").forward(request, response);
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
