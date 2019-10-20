package pe.edu.upn.marriott;

import java.util.Date;

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
	private HabitacionRepository habitacionRepository;
	
	@Autowired
	private TipoRepository tipoRepository;
	
	@Test
	public void contextLoads() {
		
		// Habitacion
		Habitacion habitacion1 = new Habitacion();
		habitacion1.setNumeroCamas(1);
		Habitacion habitacion2 = new Habitacion();
		habitacion2.setNumeroCamas(2);
		Habitacion habitacion3 = new Habitacion();
		habitacion3.setNumeroCamas(4);
		
		habitacion1 = habitacionRepository.save(habitacion1);
		habitacion2 = habitacionRepository.save(habitacion2);
		habitacion3 = habitacionRepository.save(habitacion3);
		
		// Tipos
		Tipo matrimonial = new Tipo();
		matrimonial.setId("E01");
		matrimonial.setNombre("Matrimonial");
		Tipo doble = new Tipo();
		doble.setId("E02");
		doble.setNombre("Doble");
		Tipo extra = new Tipo();
		extra.setId("E03");
		extra.setNombre("Extra");
		
		matrimonial = tipoRepository.save(matrimonial);
		doble = tipoRepository.save(doble);
		extra = tipoRepository.save(extra);
		
		// Relacion Medico-Especialidad
		habitacion1.setTipo(matrimonial);
		habitacion2.setTipo(doble);
		
		// Relacion Especialidad-medico
		extra.addHabitacion(habitacion3);
		
		// grabar
		habitacionRepository.save(habitacion1);
		habitacionRepository.save(habitacion2);
		habitacionRepository.save(habitacion3);
		tipoRepository.save(matrimonial);
		tipoRepository.save(doble);
		tipoRepository.save(extra);			
	
	} 
	}

