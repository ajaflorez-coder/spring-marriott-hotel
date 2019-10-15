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
	
	@Column(name="precio",nullable = false)
	private Float precio;
	
	@Column(name="fecha_entrada",nullable = false)
	private Date fechaEntrada;
	
	@Column(name="fecha_salida",nullable = false)
	private Float fechaSalida;
	
	@Column(name="estado",nullable = false)
	private String estado;
	
	@Column(name="observacion",nullable = false)
	private Float observacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendedor_id")
	private Vendedor vendedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "habitacion_id")
	private Habitacion habitacion;


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


	public Float getFechaSalida() {
		return fechaSalida;
	}


	public void setFechaSalida(Float fechaSalida) {
		this.fechaSalida = fechaSalida;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Float getObservacion() {
		return observacion;
	}


	public void setObservacion(Float observacion) {
		this.observacion = observacion;
	}


	public Vendedor getVendedor() {
		return vendedor;
	}


	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Habitacion getHabitacion() {
		return habitacion;
	}


	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	
	
	
}
