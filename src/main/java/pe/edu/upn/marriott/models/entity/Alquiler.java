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
	@Column(name ="id" , nullable = false)
	private Integer id;
	
	@Column(name ="precio" , nullable = false)
	private double precio;
	
	@Column(name ="Fecha_Entrada" , nullable = false)
	private Date Fecha_Entrada;
	
	@Column(name ="Fecha_Salida" , nullable = false)
	private Date Fecha_Salida;
	
	@Column(name = "estado" , length = 40 , nullable = false)
	private String estado;
	
	@Column(name = "observacion", length = 100 , nullable = false)
	private String observacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="vendedor_id")
	private Vendedor Vendedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="habitacion_id")
	private Habitacion Habitacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="cliente_id")
	private Cliente Cliente;
	
	public Alquiler() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFecha_Entrada() {
		return Fecha_Entrada;
	}

	public void setFecha_Entrada(Date fecha_Entrada) {
		Fecha_Entrada = fecha_Entrada;
	}

	public Date getFecha_Salida() {
		return Fecha_Salida;
	}

	public void setFecha_Salida(Date fecha_Salida) {
		Fecha_Salida = fecha_Salida;
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
		return Vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		Vendedor = vendedor;
	}

	public Habitacion getHabitacion() {
		return Habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		Habitacion = habitacion;
	}

	public Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}


	
	
	
}
