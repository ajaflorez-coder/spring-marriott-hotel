package pe.edu.upn.marriott.models.entity;

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
	
	@Column(name = "numeroCamas")
	private Integer numeroCamas;
	
	@Column(name = "descripcion", length = 100)
	private String descripcion;
	
	@Column(name = "precio")
	private Float precio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_id")
	private Tipo tipo;
	
	@Column(name = "observacion", length = 100)
	private String observacion;
	
	@OneToMany(mappedBy = "habitacion", fetch = FetchType.LAZY)
	private List<Alquiler> alquileres;
	
	
	public Habitacion() {
		
	}



	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	
}
