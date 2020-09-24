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
 * Servlet implementation class Registrar
 */

@Transactional
@WebServlet("/Registro")
public class Registro extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="olympicPU")
	private EntityManager em;
	
	public Registro() {
		
		super();
		
	}
	/**
     * doGet que sirve para registrar un ciclista
     * @param request - 
     * @param respone - 
     */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nombre = req.getParameter("nombre");
		String medalla = req.getParameter("medalla");
		String fecha = req.getParameter("fecha");
		System.out.println("Datos del medallista -> Nombre: " + nombre + " Tipo de medalla: " + medalla + " Fecha: " + fecha );
		
		if (nombre.trim().equals("") || medalla.trim().equals("")) {
			req.setAttribute("valNombre", nombre);
			req.setAttribute("valMedalla", medalla);
			req.setAttribute("valFecha", fecha);
			req.setAttribute("valError", "Datos incorrectos o incompletos");
			req.getRequestDispatcher("registro.jsp").forward(req, resp);
		}
		else {
			Deportista d = new Deportista();
			d.setNombre(nombre);
			d.setMedalla(medalla);
			d.setFecha(fecha);
			em.persist(d);
			req.getRequestDispatcher("Listar").forward(req, resp);
		}
		
	}
	 /**

     * Método doPost para registro de un deportista

     */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
		
	}
	
}
