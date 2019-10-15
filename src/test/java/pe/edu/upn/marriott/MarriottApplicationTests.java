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
	private ClienteRepository clienteRepository;
	
	@Autowired
	private TipoRepository tipoRepository;
	
	@Autowired
	private HabitacionRepository habitacionRepository;
	
	@Autowired
	private AlquilerRepository alquilerRepository;
	
	@Test
	public void contextLoads() {
		
		Vendedor vendedor1 = new Vendedor();
		vendedor1.setId("V001");
		vendedor1.setNombre("Adrian");
		vendedor1.setDireccion("Mi casa");
		vendedor1.setTelefono("999757476");
		vendedor1.setObservacion("Observacion por ahgsdihasgd");
		vendedor1.setSueldo((float) 373.83);
		
		vendedorRepository.save(vendedor1);
		
		Cliente cliente1 = new Cliente();
		cliente1.setId(1);
		cliente1.setNombre("Adrian No Morgan");
		cliente1.setDocumento("74847302");
		cliente1.setLugarNacimiento("Lima");
		cliente1.setSexo('M');
		cliente1.setObservacion("Observacion cliente 1");
		
		Cliente cliente2 = new Cliente();
		cliente2.setId(2);
		cliente2.setNombre("Pereyra Morgan");
		cliente2.setDocumento("74853302");
		cliente2.setLugarNacimiento("Lima");
		cliente2.setSexo('M');
		cliente2.setObservacion("Observacion cliente 2");
		
		
		Tipo tipo1 = new Tipo();
		tipo1.setId("T001");
		tipo1.setNombre("Deluxe");
		
		Habitacion habitacion1 = new Habitacion();
		habitacion1.setDescripcion("Comoda");
		habitacion1.setNumeroCamas(2);
		habitacion1.setPrecio((float)1500.50);
		habitacion1.setObservacion("Observacion de habitacion");
		habitacion1.setTipo(tipo1);
		
		Habitacion habitacion2 = new Habitacion();
		habitacion2.setDescripcion("Incomoda");
		habitacion2.setNumeroCamas(3);
		habitacion2.setPrecio((float)2000.50);
		habitacion2.setObservacion("Observacion de habitacion 2");
		habitacion2.setTipo(tipo1);
		
		Alquiler alquiler1 = new Alquiler();
		alquiler1.setPrecio((float)1000);
		alquiler1.setFechaEntrada(new Date(2019, 4, 5));
		alquiler1.setFechaSalida(new Date(2019, 5, 5));
		alquiler1.setEstado("Ocupado");
		alquiler1.setObservacion("Observacion de alquiler");
		alquiler1.setHabitacion(habitacion1);
		alquiler1.setCliente(cliente1);
		alquiler1.setVendedor(vendedor1);
		
		Alquiler alquiler2 = new Alquiler();
		alquiler2.setPrecio((float)1500);
		alquiler2.setFechaEntrada(new Date(2019, 6, 10));
		alquiler2.setFechaSalida(new Date(2019, 7, 11));
		alquiler2.setEstado("Ocupado");
		alquiler2.setObservacion("Observacion de alquiler 2");
		alquiler2.setHabitacion(habitacion2);
		alquiler2.setCliente(cliente2);
		alquiler2.setVendedor(vendedorRepository.getOne("V002"));
		
		vendedorRepository.save(vendedor1);
		clienteRepository.save(cliente1);
		clienteRepository.save(cliente2);
		tipoRepository.save(tipo1);
		habitacionRepository.save(habitacion1);
		habitacionRepository.save(habitacion2);
		alquilerRepository.save(alquiler1);
		alquilerRepository.save(alquiler2);
	}

}
