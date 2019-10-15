package pe.edu.upn.marriott.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipos")
public class Tipo {

	@Id
	@Column(name = "id", length = 4)
	private String id;
	
	@Column(name = "nombre", length = 30)
	private String nombre;

	@OneToMany(mappedBy = "tipo", fetch = FetchType.LAZY)
	private List<Habitacion> habitaciones;
	
	

}
