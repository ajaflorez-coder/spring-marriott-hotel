package pe.edu.upn.marriott;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.models.repository.HabitacionRepository;
import pe.edu.upn.marriott.models.repository.VendedorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarriottApplicationTests {

	@Autowired
	private VendedorRepository vendedorRepository;

	@Autowired
	private HabitacionRepository habitacionRepository;

	@Test
	public void contextLoads() {

		try {
			Vendedor mario = new Vendedor();
			mario.setNombre("Mario");
			mario.setDireccion("Maria Auxiliadora");
			mario.setTelefono("9857475");
			mario.setObservacion("Vendedor Eficiente");
			mario.setSueldo(800F);

			mario = vendedorRepository.save(mario);

			// habitacion

			Habitacion lujosa = new Habitacion();
			lujosa.setNumeroCamas(3);
			lujosa.setDescripcion("Habitacion Lujosa");
			lujosa.setPrecio(500F);
			lujosa.setObservacion("habitacion preferida");

			lujosa = habitacionRepository.save(lujosa);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
