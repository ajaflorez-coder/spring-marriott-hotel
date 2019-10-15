package pe.edu.upn.marriott;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.repository.AlquilerRepository;
import pe.edu.upn.marriott.models.repository.HabitacionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarriottApplicationTests {
	@Autowired
	private AlquilerRepository alquilerRepository;
	
	@Autowired
	private HabitacionRepository habitacionRepository;

	@Test
	public void contextLoads() {
		
		try {
			
			Habitacion matrimonial=new Habitacion();
			matrimonial.setDescripcion("Matrimonial");
			matrimonial.setNumeroCamas(1);
			
			matrimonial=habitacionRepository.save(matrimonial);
			habitacionRepository.save(matrimonial);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}

}
