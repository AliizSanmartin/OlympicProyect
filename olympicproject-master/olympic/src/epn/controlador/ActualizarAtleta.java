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
 * Servlet implementation class ActualizarAtleta
 */
@Transactional
@WebServlet("/ActualizarAtleta")
public class ActualizarAtleta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@PersistenceContext(unitName="olympicPU")
	private EntityManager em;
	
    public ActualizarAtleta() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String medalla = request.getParameter("medalla");
		String fecha = request.getParameter("fecha");

		if (nombre.trim().equals("") || medalla.trim().equals("")) {
			request.setAttribute("valNombre", nombre);
			request.setAttribute("valMedalla", medalla);
			request.setAttribute("valFecha", fecha);
			request.setAttribute("valError", "Datos incorrectos o incompletos");
			request.getRequestDispatcher("editar.jsp").forward(request, response);
		}
		else {
			DeportistaAtletismo d = em.find(DeportistaAtletismo.class, Integer.parseInt(id));
			d.setNombre(nombre);
			d.setMedalla(medalla);
			d.setFecha(fecha);
			em.persist(d);
			request.getRequestDispatcher("ListarAtletismo").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
