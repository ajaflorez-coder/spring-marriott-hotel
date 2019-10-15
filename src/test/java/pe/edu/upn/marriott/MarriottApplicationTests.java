package pe.edu.upn.marriott;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.repository.HabitacionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarriottApplicationTests {
	@Autowired
	private HabitacionRepository habitacionRepository;
	@Test
	public void contextLoads() {
		try {
			Habitacion habitacion1=new Habitacion();
			habitacion1.setNumeroCamas(23);
			habitacion1.setDescripcion("locazo");
			habitacion1.setPrecio((float) 22.11);
			habitacion1.setObservacion("ojos");
			habitacionRepository.save(habitacion1);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
