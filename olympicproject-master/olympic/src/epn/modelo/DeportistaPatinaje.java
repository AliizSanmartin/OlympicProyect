package epn.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Miguel Reina - Alisson Sanmartín - Edison Almeida
 * Implementation entidad Deportista Patinaje
 */
@Entity
public class DeportistaPatinaje {
	@Id
	@Column(name="idDep")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nombre;
	
	@Column
	private String medalla;
	
	@Column
	private String fecha;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getMedalla() {
		return medalla;
	}
	public void setMedalla(String medalla) {
		this.medalla = medalla;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
