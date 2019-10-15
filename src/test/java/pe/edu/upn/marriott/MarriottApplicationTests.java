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
			
			//Alquiler
			
			Alquiler h1 = new Alquiler();
			h1.setPrecio((float)250.00);
			h1.setFecha_entrada(new Date(2019, 10, 15));
			h1.setFecha_salida(new Date(2019, 10, 17));
			h1.setEstado("5 estrellas");
			h1.setObservacion("Con jacuzzi");
			
			
			
			h1 = alquilerRepository.save(h1);
			
			
			// Vendedores
			Vendedor v1 = new Vendedor();
			v1.setId("S01");
			v1.setNombre("Samuel");
			v1.setDireccion("Av Peru 4031");
			v1.setTelefono("949103265");
			v1.setObservacion("Detalle");
			v1.setSueldo((float) 1000.00);
			
		
						
			v1 = vendedorRepository.save(v1);
			
			
			// Habitacion
			Habitacion H102 = new Habitacion();
			H102.setId(01);
			H102.setNumeroCamas(4);
			H102.setDescripcion("Limpio");
			H102.setPrecio((float) 150.00);
			H102.setObservacion("No fumar");
		
		H102 = habitacionRepository.save(H102);
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}

}
