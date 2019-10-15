package pe.edu.upn.marriott.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.repository.AlquilerRepository;

import pe.edu.upn.marriott.services.AlquilerService;

@Service
public class AlquilerServiceImpl implements AlquilerService {
	
	
	@Autowired
	private AlquilerRepository alquilerRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Alquiler> findAll() throws Exception {
		return alquilerRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Alquiler> findById(Integer id) throws Exception {
		return alquilerRepository.findById(id);
	}

	@Override
	
	public Alquiler save(Alquiler entity) throws Exception {
		return alquilerRepository.save(entity);
	}

	@Override
	
	public Alquiler update(Alquiler entity) throws Exception {
		return alquilerRepository.save(entity);
	}

	@Override
	
	public void deleteById(Integer id) throws Exception {
		alquilerRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		alquilerRepository.deleteAll();
		
	}
	
	

}
