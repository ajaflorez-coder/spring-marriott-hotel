package pe.edu.upn.marriott;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.entity.Tipo;
import pe.edu.upn.marriott.models.repository.AlquilerRepository;
import pe.edu.upn.marriott.models.repository.HabitacionRepository;
import pe.edu.upn.marriott.models.repository.TipoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarriottApplicationTests {

	@Autowired
	private HabitacionRepository habitacionRepository;
	@Autowired
	private AlquilerRepository alquilerRepository;
	
	@Autowired
	private TipoRepository tipoRepository;
	
	@Test
	public void contextLoads() {
		try {
			/*Paciente antiguo = null;
			Optional<Paciente> caja = pacienteRepository.findById("N01");
			if(caja.isPresent())
				antiguo = caja.get();*/
			
			Tipo tipo = new Tipo();			
			tipo.setNombre("MATRIMONIAL");
		
			tipo = tipoRepository.save(tipo);
			
			Habitacion habitacion = new Habitacion();
			habitacion.setNumeroCamas(2);
			habitacion.setDescripcion("Habitacion para recien casados");
			habitacion.setPrecio(500F);
			habitacion.setObservacion("Máximo reserva 4 días");
	
			habitacion = habitacionRepository.save(habitacion);
			
			Alquiler alquiler = new Alquiler();
			alquiler.setPrecio(700F);
			alquiler.setFecha_entrada(new Date(2019, 9, 9));
			alquiler.setFecha_salida(new Date(2019, 9, 12));
			alquiler.setEstado("1");
			alquiler.setObservacion("Valido por temporada");
			
			
		
			alquiler = alquilerRepository.save(alquiler);
			
			
			
		
			
			// grabar
			tipoRepository.save(tipo);
			habitacionRepository.save(habitacion);
			alquilerRepository.save(alquiler);
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
