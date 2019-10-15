package pe.edu.upn.marriott;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.entity.Cliente;
import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.entity.Tipo;
import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.models.repository.AlquilerRepository;
import pe.edu.upn.marriott.models.repository.ClienteRepository;
import pe.edu.upn.marriott.models.repository.HabitacionRepository;
import pe.edu.upn.marriott.models.repository.TipoRepository;
import pe.edu.upn.marriott.models.repository.VendedorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarriottApplicationTests {

	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired 
	private AlquilerRepository alquilerRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private TipoRepository tipoRepository;
	
	@Autowired
	private HabitacionRepository habitacionRepository;
	
	@Test
	public void contextLoads() {
		
		try {
			//Vendedor
			Vendedor vendedor1=new Vendedor();
			vendedor1.setId("e1");
			vendedor1.setDireccion("d1");
			vendedor1.setTelefono("98254");
			vendedor1.setObservacion("o1");
			vendedor1.setSueldo(1500f);
			
			vendedor1=vendedorRepository.save(vendedor1);
			
			//Alquiler
			Alquiler alquiler1=new Alquiler();
			alquiler1.setPrecio(15f);
			alquiler1.setFechaEntrada(new Date(2018,9,8));
			alquiler1.setFechaSalida(new Date (2016,10,8));
			alquiler1.setEstado("Ocupado");
			alquiler1.setObservacion("Rentado");
			
			alquiler1=alquilerRepository.save(alquiler1);
			
			//Cliente
			Cliente cliente1=new Cliente();
			cliente1.setDocumento("72436678");
			cliente1.setNombre("Lilian");
			cliente1.setFechaNacimiento(new Date(1999,4,28));
			cliente1.setLugarNacimiento("Trujillo");
			cliente1.setSexo('F');
			cliente1.setObservacion("observacion");
			
			cliente1=clienteRepository.save(cliente1);
			
			//Tipo 
			Tipo tipo1=new Tipo();
			tipo1.setId("T1");
			tipo1.setNombre("VIP");
			
			tipo1=tipoRepository.save(tipo1);
			
			//Habitacion
			Habitacion habitacion1=new Habitacion();
			habitacion1.setNumeroCamas(2);
			habitacion1.setDescripcion("descripcion");
			habitacion1.setPrecio(1800f);
			habitacion1.setObservacion("observacion");
			
			habitacion1=habitacionRepository.save(habitacion1);
			
			
			//Relaciones
			//relacion vendedor-alquiler
			vendedor1.addAlquiler(alquiler1);
			
			//relacion cliente-alquiler
			cliente1.addCliente(alquiler1);
			
			//relacion tipo-habitacion
			tipo1.addHabitacion(habitacion1);
			
			//relacion habitacion-alquiler
			habitacion1.addAlquiler(alquiler1);
			
			//grabar
			alquilerRepository.save(alquiler1);
			clienteRepository.save(cliente1);
			vendedorRepository.save(vendedor1);
			tipoRepository.save(tipo1);
			habitacionRepository.save(habitacion1);
			
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
