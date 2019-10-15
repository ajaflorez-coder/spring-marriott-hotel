package pe.edu.upn.marriott;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.upn.marriott.models.entity.Cliente;
import pe.edu.upn.marriott.models.repository.ClienteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarriottApplicationTests {

	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Test
	public void contextLoads() {
		
		
		try {
			Cliente chris = new Cliente();
			chris.setDocumento("995684621");
			chris.setNombre("chris");
			chris.setFechaNacimiento(new Date(2019,9,9));
			chris.setLugarNacimiento("chorrillos");
			chris.setSexo('M');
			chris.setObservacion("hola como estas");
			
			
			clienteRepository.save(chris);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
