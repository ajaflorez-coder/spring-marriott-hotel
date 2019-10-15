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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "alquileres")
public class Alquiler {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "precio")
	private Float precio;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_entrada")
	private Date fechaEntrada;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_salida")
	private Date fechaSalida;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "observacion")
	private String observacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendedor_id")
	private Vendedor vendedorID;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private Cliente clienteID;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "habitacion_id")
	private Habitacion habitacionID;
	
	
	public Alquiler() {
		
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Float getPrecio() {
		return precio;
	}


	public void setPrecio(Float precio) {
		this.precio = precio;
	}


	public Date getFechaEntrada() {
		return fechaEntrada;
	}


	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}


	public Date getFechaSalida() {
		return fechaSalida;
	}


	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
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


	public Vendedor getVendedorID() {
		return vendedorID;
	}


	public void setVendedorID(Vendedor vendedorID) {
		this.vendedorID = vendedorID;
	}


	public Cliente getClienteID() {
		return clienteID;
	}


	public void setClienteID(Cliente clienteID) {
		this.clienteID = clienteID;
	}


	public Habitacion getHabitacionID() {
		return habitacionID;
	}


	public void setHabitacionID(Habitacion habitacionID) {
		this.habitacionID = habitacionID;
	}


	
	
	
}
