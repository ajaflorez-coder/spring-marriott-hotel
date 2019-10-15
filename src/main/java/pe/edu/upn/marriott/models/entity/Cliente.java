package pe.edu.upn.marriott.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<Alquiler> alquileres;
	
	public Cliente() {
		alquileres = new ArrayList<>();
	}
	
	public void addAlquiler(Alquiler alquiler) {
		alquileres.add(alquiler);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public List<Alquiler> getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(List<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}
	
	
	
}
