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
	
	@Column(name="precio", length = 50)
	private Float precio; 
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date fecha_entrada;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date fecha_salida;
	
	@Column(name="estado", length =30)
	private String estado;
	
	@Column(name="observacion", length =30)
	private String observacion;
	 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cliente_id") 
    private Cliente cliente;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="vendedor_id")
    private Vendedor vendedor; 
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="habitacion_id")
    private Habitacion habitacion;
	 
    
	
}
