package pe.edu.upn.marriott.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alquileres")
public class Alquiler {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "precio")
	private Double precio;
	
	@Column(name = "fecha_entrada")
	private Date fecha_entrada;
	
	@Column(name = "fecha_salida")
	private Date fecha_salida;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "observacion")
	private String observacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendedor_id")
	private Vendedor vendedores;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private Cliente clientes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "habitacion_id")
	private Habitacion habitaciones;
	
	
  public Alquiler (){
	 
  }


public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


public Double getPrecio() {
	return precio;
}


public void setPrecio(Double precio) {
	this.precio = precio;
}


public Date getFecha_entrada() {
	return fecha_entrada;
}


public void setFecha_entrada(Date fecha_entrada) {
	this.fecha_entrada = fecha_entrada;
}


public Date getFecha_salida() {
	return fecha_salida;
}


public void setFecha_salida(Date fecha_salida) {
	this.fecha_salida = fecha_salida;
}


public String getEstado() {
	return estado;
}


public void setEstado(String estado) {
	this.estado = estado;
}


public String getObservacion() {
	return observacion;
}


public void setObservacion(String observacion) {
	this.observacion = observacion;
}


public Vendedor getVendedores() {
	return vendedores;
}


public void setVendedores(Vendedor vendedores) {
	this.vendedores = vendedores;
}


public Cliente getClientes() {
	return clientes;
}


public void setClientes(Cliente clientes) {
	this.clientes = clientes;
}


public Habitacion getHabitaciones() {
	return habitaciones;
}


public void setHabitaciones(Habitacion habitaciones) {
	this.habitaciones = habitaciones;
}






	 
}
