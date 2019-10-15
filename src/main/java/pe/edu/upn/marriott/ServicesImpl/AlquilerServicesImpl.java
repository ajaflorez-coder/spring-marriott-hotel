package pe.edu.upn.marriott.ServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.repository.AlquilerRepository;
import pe.edu.upn.marriott.services.AlquilerServices;

@Service
public class AlquilerServicesImpl implements AlquilerServices{
	
	@Autowired
	private AlquilerRepository alquilerRepository;

	@Override
	public List<Alquiler> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Alquiler> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alquiler save(Alquiler entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alquiler update(Alquiler entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
