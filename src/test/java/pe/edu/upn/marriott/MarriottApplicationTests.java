package pe.edu.upn.marriott;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.entity.Tipo;
import pe.edu.upn.marriott.models.repository.HabitacionRepository;
import pe.edu.upn.marriott.models.repository.TipoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarriottApplicationTests {
	
	@Autowired
	private TipoRepository tipoRepository;
	@Autowired
	private HabitacionRepository habitacionRepository;
	
	private float precio1=85;
	private float precio2=100;
	private float precio3=150;

	@Test
	public void contextLoads() {
		
		try {
			
		/*	// Especialidad
			Tipo tipo1= new Tipo();
			tipo1.setId("E001");
			tipo1.setNombre("Matrimonial");
			Tipo tipo2= new Tipo();
			tipo1.setId("E002");
			tipo1.setNombre("Doble");
			Tipo tipo3= new Tipo();
			tipo1.setId("E003");
			tipo1.setNombre("VIP");
			
			
			tipo1 = tipoRepository.save(tipo1);
			tipo2 = tipoRepository.save(tipo2);
			tipo3 = tipoRepository.save(tipo3);
			
			
			//grabar
			tipoRepository.save(tipo1);
			tipoRepository.save(tipo2);
			tipoRepository.save(tipo3);
			*/
			
		/*	// Habitaciones
			Habitacion habitacion1= new Habitacion();
			habitacion1.setNumeroCamas(2);
			habitacion1.setPrecio(precio1);
			habitacion1.setObservacion("observacion");
			habitacion1.setDescripcion("descripcion");
			
			Habitacion medico2 = new Medico();
			medico2.setNombre("medico 2");
			Habitacion medico3 = new Medico();
			medico3.setNombre("medico 3");
			
			medico1 = medicoRepository.save(medico1);
			medico2 = medicoRepository.save(medico2);
			medico3 = medicoRepository.save(medico3);
			
*/
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
