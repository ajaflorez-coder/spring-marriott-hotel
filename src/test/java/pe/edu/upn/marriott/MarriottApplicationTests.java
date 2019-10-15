package pe.edu.upn.marriott;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.models.repository.AlquilerRepository;
import pe.edu.upn.marriott.models.repository.VendedorRepository;

import org.springframework.beans.factory.annotation.Autowired;




@RunWith(SpringRunner.class)
@SpringBootTest
public class MarriottApplicationTests {

	
	@Autowired 
	private VendedorRepository vendedorRepository;
	@Autowired
	private AlquilerRepository alquilerRepository;
	
	
	@Test
	public void contextLoads() {
		
		try {
			Vendedor vendedor1 = new Vendedor();
			vendedor1.setNombre("Juan");
			Vendedor vendedor2 = new Vendedor();
			vendedor2.setNombre("Jose");
			Vendedor vendedor3 = new Vendedor();
			vendedor3.setNombre("Pedro");
			
			vendedor1 = vendedorRepository.save(vendedor1);
			vendedor2 = vendedorRepository.save(vendedor2);
			vendedor3 = vendedorRepository.save(vendedor3);
			
			//Alquiler
			Alquiler veinte = new Alquiler();
			veinte.setId(0001);
			veinte.setObservacion("veinte soles");
			
			Alquiler treinta = new Alquiler();
			treinta.setId(0002);
			veinte.setObservacion("treinta soles");
			
			Alquiler cuarenta = new Alquiler();
			cuarenta.setId(0001);
			cuarenta.setObservacion("cuarenta soles");
			
			veinte = alquilerRepository.save(veinte);
			treinta = alquilerRepository.save(treinta);
			cuarenta = alquilerRepository.save(cuarenta);
			
			
			//Relacion
			
			
			
			//grabar
			vendedorRepository.save(vendedor1);
			vendedorRepository.save(vendedor2);
			vendedorRepository.save(vendedor3);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
