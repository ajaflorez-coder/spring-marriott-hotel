package pe.edu.upn.marriott;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.upn.marriott.models.entity.Habitacion;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarriottApplicationTests {

	@Test
	public void contextLoads() {
		
		Habitacion antiguo = new Habitacion();
		antiguo.setId(01);
		antiguo.setNumeroCamas(24);
		antiguo.setDescripcion("Habitacion limpia");
		antiguo.setPrecio(1525);
		antiguo.setTipo(null);
		antiguo.setObservacion("Vista a la Playa");
	}

}
