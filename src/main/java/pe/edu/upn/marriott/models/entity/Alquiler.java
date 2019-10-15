package pe.edu.upn.marriott.models.entity;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "alquileres")
public class Alquiler {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "precio", nullable = false)
	private int precio;
	
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name="fecha_entrada" , nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fecha_entrada;
	
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name="fecha_salida" , nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fecha_salida;
	
	@Column(name="estado", nullable = false)
	private String estado;
	
	@Column(name="observacion", length = 100)
	private String observacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendedor_id")
	private Vendedor vendedor;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private Cliente clientes;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "habitacion_id")
	private Habitacion habitaciones;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
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


	public Vendedor getVendedor() {
		return vendedor;
	}


	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
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
