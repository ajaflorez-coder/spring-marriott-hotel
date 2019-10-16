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

import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "alquileres")
public class Alquiler {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private Float precio;
	
	public Alquiler() {
		super();
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_entrada")
	private Date fechaEntrada;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_salida")
	private Date fechaSalida;
	
	@Column(name = "observacion", length = 60)
	private String observacion;
	
	@Column(name = "estado", length = 60)
	private Boolean estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "cliente_id" )
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "vendedor_id" )
	private Vendedor vendedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "habitacion_id" )
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

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Alquiler(Integer id, Float precio, Date fechaEntrada, Date fechaSalida, String observacion, Boolean estado,
			Cliente cliente, Vendedor vendedor, Habitacion habitacion) {
		super();
		this.id = id;
		this.precio = precio;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.observacion = observacion;
		this.estado = estado;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.habitacion = habitacion;
	}
	
	
	
	
	
}
