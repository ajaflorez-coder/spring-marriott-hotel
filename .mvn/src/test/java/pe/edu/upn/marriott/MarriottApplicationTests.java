package pe.edu.upn.marriott;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.upn.marriott.models.entity.Tipo;
import pe.edu.upn.marriott.models.repository.TipoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarriottApplicationTests {

	@Autowired
	private TipoRepository tipoRepository;
	
	@Test
	public void contextLoads() {
		try {
			
			Tipo tipo1 = new Tipo();
			tipo1.setId("C01");
			tipo1.setNombre("Duplex");
			
			tipo1 = tipoRepository.save(tipo1);
			tipoRepository.save(tipo1);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
