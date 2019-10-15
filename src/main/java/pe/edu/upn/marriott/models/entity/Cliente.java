package pe.edu.upn.marriott.models.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	
	
	@Column(name = "fecha_Nacimiento")	
	private String fechaNacimiento;
	
	@Column(name = "lugar_Nacimiento", length = 50)
	private String lugarNacimiento;
	
	@Column(name = "sexo", length = 50)
	private String sexo;
	
	@Column(name = "observacion", length = 100)
	private String observacion;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<Alquiler> alquiler;
	
	
	
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







	public String getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public String getLugarNacimiento() {
		return lugarNacimiento;
	}



	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}


	public String getSexo() {
		return sexo;
	}



	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	public String getObservacion() {
		return observacion;
	}



	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}



	public List<Alquiler> getAlquiler() {
		return alquiler;
	}



	public void setAlquiler(List<Alquiler> alquiler) {
		this.alquiler = alquiler;
	}



	public Cliente() {
		
	}
	
}
