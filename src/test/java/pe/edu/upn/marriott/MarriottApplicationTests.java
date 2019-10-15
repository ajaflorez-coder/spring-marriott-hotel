package pe.edu.upn.marriott;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.models.repository.VendedorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarriottApplicationTests {

	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Test
	public void contextLoads() {
		
		Vendedor vendedor1 = new Vendedor();
		vendedor1.setId("V001");
		vendedor1.setNombre("Adrian");
		vendedor1.setDireccion("Mi casa");
		vendedor1.setTelefono("999757476");
		vendedor1.setObservacion("Observacion por ahgsdihasgd");
		vendedor1.setSueldo((float) 373.83);
		
		vendedorRepository.save(vendedor1);
	}

}
