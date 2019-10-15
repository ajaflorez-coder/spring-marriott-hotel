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

import org.springframework.format.number.money.MonetaryAmountFormatter;

@Entity
@Table(name = "alquileres")
public class Alquiler {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name ="precio", nullable = false )
	private Float precio;
	
	@Column(name = "fecha_entrada", nullable = false)
	private Date fechanacimiento;
	
	@Column(name = "fecha_salida", nullable = false)
	private Date fechasalida;
	
	@Column(name = "estado", nullable = false)
	private String estado;
	
	@Column(name = "observacion", nullable = false)
	private String observacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendedor_id")
	private Vendedor vendedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "habitacion_id")
	private Habitacion habitacion;

	public Alquiler(Integer id, Float precio, Date fechanacimiento, Date fechasalida, String estado, String observacion,
			Vendedor vendedor, Cliente cliente, Habitacion habitacion) {
		super();
		this.id = id;
		this.precio = precio;
		this.fechanacimiento = fechanacimiento;
		this.fechasalida = fechasalida;
		this.estado = estado;
		this.observacion = observacion;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.habitacion = habitacion;
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

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public Date getFechasalida() {
		return fechasalida;
	}

	public void setFechasalida(Date fechasalida) {
		this.fechasalida = fechasalida;
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
