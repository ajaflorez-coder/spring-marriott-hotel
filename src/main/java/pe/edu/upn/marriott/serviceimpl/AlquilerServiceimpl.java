package pe.edu.upn.marriott.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.repository.AlquilerRepository;
import pe.edu.upn.marriott.service.AlquilerService;

@Service
public class AlquilerServiceimpl implements AlquilerService{

	@Autowired
	private AlquilerRepository alquilerRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Alquiler> findAll() throws Exception {
		return alquilerRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Alquiler> findById(Integer id) throws Exception {
		return alquilerRepository.findById(id);
	}

	@Transactional
	@Override
	public Alquiler save(Alquiler entity) throws Exception {
		return alquilerRepository.save(entity);
	}

	@Transactional
	@Override
	public Alquiler update(Alquiler entity) throws Exception {
		return alquilerRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		alquilerRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		alquilerRepository.deleteAll();
	}
	
	
}
