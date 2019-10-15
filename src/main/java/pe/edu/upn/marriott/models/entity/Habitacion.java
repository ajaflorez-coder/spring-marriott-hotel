package pe.edu.upn.marriott.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "habitaciones")
public class Habitacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "numero_Camas")
	private Integer numeroCamas;
	
	@Column(name = "descripcion", length = 100)
	private String descripcion;
	
	@Column(name = "precio")
	private Float precio;
	
	@Column(name = "observacion", length = 100)
	private String observacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_id")
	private Tipo tipo;
	
	@OneToMany(mappedBy = "habitacion" , fetch = FetchType.LAZY)
	private List<Alquiler> alquileres;
	
	
	public Habitacion() {
		alquileres=new ArrayList<>();
	}
	
	public void addAlquiler(Alquiler alquiler) {
		alquiler.setHabitacion(this);
		this.alquileres.add(alquiler);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroCamas() {
		return numeroCamas;
	}

	public void setNumeroCamas(Integer numeroCamas) {
		this.numeroCamas = numeroCamas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<Alquiler> getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(List<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}

	

	/*public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}*/
	
	
}
