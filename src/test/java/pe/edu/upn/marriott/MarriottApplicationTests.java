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
	
	try {
		
		Vendedor juan = new Vendedor();
		juan.setId("n01");
		juan.setDireccion("lala");
		juan.setNombre("juan");
		juan.setTelefono("987654321");
		juan.setObservacion("xd");
		juan.setSueldo("1500");
		
		vendedorRepository.save(juan);
		
		
		
	}catch (Exception e) {
		System.out.println(e.getMessage());
	}
  
	}
}
