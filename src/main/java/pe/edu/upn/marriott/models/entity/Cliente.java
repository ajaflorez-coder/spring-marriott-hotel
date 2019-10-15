package pe.edu.upn.marriott.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "documento", length = 8)
	private String documento;
	
	@Column(name = "nombre", length = 60)
	private String nombre;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_Nacimiento")	
	private Date fechaNacimiento;
	
	@Column(name = "lugar_Nacimiento", length = 50)
	private String lugarNacimiento;
	
	@Column(name = "sexo", length = 1)
	private char sexo;
	
	@Column(name = "observacion", length = 100)
	private String observacion;
	
	@OneToMany(mappedBy = "clientes")
	private List<Alquiler> alquileres ;
	
	
	
	public Cliente() {
		alquileres= new ArrayList<>();
	}
	
}
