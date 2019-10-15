package pe.edu.upn.marriott;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.models.repository.AlquilerRepository;
import pe.edu.upn.marriott.models.repository.HabitacionRepository;
import pe.edu.upn.marriott.models.repository.VendedorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarriottApplicationTests {

	@Autowired
	private VendedorRepository vendedorRepository;
	@Autowired
	private AlquilerRepository alquilerRepository;
	@Autowired
	private HabitacionRepository habitacionRepository;
	
	@Test
	public void contextLoads() {
		
		try {
			
			//Vendedores
			Vendedor juan = new Vendedor();
			juan.setId("V01");
			juan.setNombre("Juan");
			juan.setDireccion("Av. Garzon");
			juan.setTelefono("9823452");
			juan.setObservacion("al dia");
			juan.setSueldo((float) 979.34);
			
			Vendedor mario = new Vendedor();
			mario.setId("V02");
			mario.setNombre("Mario");
			mario.setDireccion("Av. Vizcarra");
			mario.setTelefono("9863852");
			mario.setObservacion("excelente");
			mario.setSueldo((float) 1050.90);
			
			Vendedor cesar = new Vendedor();
			cesar.setId("V03");
			cesar.setNombre("Cesar");
			cesar.setDireccion("Av. Ramon Castilla");
			cesar.setTelefono("9803952");
			cesar.setObservacion("eficiente");
			cesar.setSueldo((float) 1243.90);
			
			juan = vendedorRepository.save(juan);
			mario = vendedorRepository.save(mario);
			cesar = vendedorRepository.save(cesar);
			
			//Alquileres
			Alquiler n01 = new Alquiler();
			n01.setPrecio((float) 50.10);
			n01.setFechaEntrada(new Date(119, 9, 15));
			n01.setFechaSalida(new Date(119, 9, 16));
			n01.setEstado("muy bueno");
			n01.setObservacion("duradero");
			
			Alquiler n02 = new Alquiler();
			n02.setPrecio((float) 40.10);
			n02.setFechaEntrada(new Date(119, 5, 10));
			n02.setFechaSalida(new Date(119, 5, 11));
			n02.setEstado("regular");
			n02.setObservacion("con ducha");
			
			Alquiler n03 = new Alquiler();
			n03.setPrecio((float) 45.10);
			n03.setFechaEntrada(new Date(119, 9, 5));
			n03.setFechaSalida(new Date(119, 9, 6));
			n03.setEstado("pasable");
			n03.setObservacion("colorido");
			
			n01 = alquilerRepository.save(n01);
			n02 = alquilerRepository.save(n02);
			n03 = alquilerRepository.save(n03);
			
			//Habitaciones
			Habitacion h1 = new Habitacion();
			h1.setNumeroCamas(2);
			h1.setDescripcion("comodas");
			h1.setPrecio((float) 15.80);
			h1.setObservacion("acolchadas");
			
			Habitacion h2 = new Habitacion();
			h2.setNumeroCamas(3);
			h2.setDescripcion("blandas");
			h2.setPrecio((float) 34.42);
			h2.setObservacion("amobladas");
			
			Habitacion h3 = new Habitacion();
			h3.setNumeroCamas(1);
			h3.setDescripcion("acogedora");
			h3.setPrecio((float) 12.30);
			h3.setObservacion("lucida");
			
			h1 = habitacionRepository.save(h1);
			h2 = habitacionRepository.save(h2);
			h3 = habitacionRepository.save(h3);

			//Relacion vendedor-alquiler
			juan.addAlquiler(n01);;
			mario.addAlquiler(n03);
			
			//Relacion alquiler-vendedor

			n02.setVendedor(cesar);

			
			//Relacion alquiler-habitacion
			n01.setHabitacion(h3);
			n02.setHabitacion(h1);

			
			//Relacion habitacion-alquiler
			h2.addAlquiler(n03);
			
			//grabar
			vendedorRepository.save(juan);
			vendedorRepository.save(mario);
			vendedorRepository.save(cesar);
			alquilerRepository.save(n01);
			alquilerRepository.save(n02);
			alquilerRepository.save(n03);
			habitacionRepository.save(h1);
			habitacionRepository.save(h2);
			habitacionRepository.save(h3);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			}
		
	}

}
