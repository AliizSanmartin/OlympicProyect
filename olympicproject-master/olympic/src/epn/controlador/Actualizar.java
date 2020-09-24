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
 * Servlet implementation class Actualizar
 */
/**
 * 
 * Clase Autualizar java Inicio y configuracion de la persistencia
 *
 */
@Transactional
@WebServlet("/Actualizar")
public class Actualizar extends HttpServlet{
	private static final long serialVersionUID =1L;
	
	@PersistenceContext(unitName="olympicPU")
	private EntityManager em;
	
	public Actualizar() {
		
		super();
		
	}
	/**
     * doGet que sirve para actualizar datos
     * @param request - 
     * @param respone - 
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String nombre = req.getParameter("nombre");
		String medalla = req.getParameter("medalla");
		String fecha = req.getParameter("fecha");

		if (nombre.trim().equals("") || medalla.trim().equals("")) {
			req.setAttribute("valNombre", nombre);
			req.setAttribute("valMedalla", medalla);
			req.setAttribute("valFecha", fecha);
			req.setAttribute("valError", "Datos incorrectos o incompletos");
			req.getRequestDispatcher("editar.jsp").forward(req, resp);
		}
		else {
			Deportista d = em.find(Deportista.class, Integer.parseInt(id));
			d.setNombre(nombre);
			d.setMedalla(medalla);
			d.setFecha(fecha);
			em.persist(d);
			req.getRequestDispatcher("Listar").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
		
	}	
	
}
