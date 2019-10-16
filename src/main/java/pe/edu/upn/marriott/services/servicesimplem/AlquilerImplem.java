package pe.edu.upn.marriott.services.servicesimplem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.repository.AlquilerRepository;
import pe.edu.upn.marriott.services.AlquilerService;

@Service
public class AlquilerImplem implements AlquilerService {

	@Autowired AlquilerRepository alquiler;
	
	@Override
	public List<Alquiler> findAll() throws Exception {
		// TODO Auto-generated method stub
		return alquiler.findAll();
	}

	@Override
	public Optional<Alquiler> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return alquiler.findById(id);
	}

	@Override
	public Alquiler save(Alquiler entity) throws Exception {
		// TODO Auto-generated method stub
		return alquiler.save(entity);
	}

	@Override
	public Alquiler update(Alquiler entity) throws Exception {
		// TODO Auto-generated method stub
		return alquiler.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		alquiler.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		alquiler.deleteAll();
	}

}
