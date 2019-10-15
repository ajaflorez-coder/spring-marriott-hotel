package pe.edu.upn.marriott;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.models.repository.AlquilerRepository;
import pe.edu.upn.marriott.models.repository.VendedorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarriottApplicationTests {

	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired 
	private AlquilerRepository alquilerRepository;
	
	@Test
	public void contextLoads() {
		//Vendedor
		Vendedor ven1=new Vendedor();
		ven1.setId("e1");
		ven1.setDireccion("d1");
		ven1.setTelefono("98254");
		ven1.setObservacion("o1");
		//ven1.setSueldo(25.54);
		
		ven1=vendedorRepository.save(ven1);
		
		
		
	}

}
