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
	private HabitacionRepository habitacionRepository;
	@Autowired
	private TipoRepository tipoRepository;
	@Test
	public void contextLoads() {
		try {
			Tipo tipo1=new Tipo();
		    tipo1.setId("j001");
			tipo1.setNombre("jota");
			
			tipoRepository.save(tipo1);
			
			Habitacion habitacion1=new Habitacion();
			habitacion1.setNumeroCamas(23);
			habitacion1.setDescripcion("locazo");
			habitacion1.setPrecio((float) 22.11);
			habitacion1.setObservacion("ojaaaassosos");
			habitacion1.setTipo(tipo1);
			habitacionRepository.save(habitacion1);
			
			Tipo tipo2=new Tipo();
		    tipo1.setId("j002");
			tipo1.setNombre("jota");
			tipo1.addHabitacion(habitacion1);
			tipoRepository.save(tipo2);
		    
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
