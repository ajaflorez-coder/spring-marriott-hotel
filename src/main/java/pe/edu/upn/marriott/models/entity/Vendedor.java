package pe.edu.upn.marriott.models.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vendedores")
public class Vendedor {
	
	@Id
	@Column(name = "id", length = 4)
	private String id;
	
	@Column(name = "nombre", length = 60)
	private String nombre;
	
	@Column(name = "direccion", length = 70)
	private String direccion;

	@Column(name = "telefono", length = 20)
	private String telefono;
	
	@Column(name = "observacion", length = 100)
	private String observacion;
	
	@Column(name = "sueldo")
	private Float sueldo;
	
	@OneToMany(mappedBy = "vendedor",fetch = FetchType.LAZY)
	List<Alquiler> alquileres;
	
	
	
	public Vendedor(String id, String nombre, String direccion, String telefono, String observacion, Float sueldo,
			List<Alquiler> alquileres) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.observacion = observacion;
		this.sueldo = sueldo;
		this.alquileres = alquileres;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getObservacion() {
		return observacion;
	}



	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}



	public Float getSueldo() {
		return sueldo;
	}



	public void setSueldo(Float sueldo) {
		this.sueldo = sueldo;
	}



	public List<Alquiler> getAlquileres() {
		return alquileres;
	}



	public void setAlquileres(List<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}



	public Vendedor() {
		
	}
}
