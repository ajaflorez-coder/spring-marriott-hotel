package pe.edu.upn.marriott.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.repository.AlquilerRepository;
import pe.edu.upn.marriott.services.AlquilerService;

@Service
public class AlquilerServicesImpl implements AlquilerService{
	@Autowired
	private AlquilerRepository alquilerrepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Alquiler> findAll() throws Exception {
		// TODO Auto-generated method stub
		return alquilerrepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Alquiler> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return alquilerrepository.findById(id);
	}

	@Override
	@Transactional
	public Alquiler save(Alquiler entity) throws Exception {
		// TODO Auto-generated method stub
		return alquilerrepository.save(entity);
	}

	@Override
	public Alquiler update(Alquiler entity) throws Exception {
		// TODO Auto-generated method stub
		return alquilerrepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		alquilerrepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		alquilerrepository.deleteAll();
	}
}
