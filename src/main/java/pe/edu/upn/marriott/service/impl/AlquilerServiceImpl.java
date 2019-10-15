package pe.edu.upn.marriott.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.repository.AlquilerRepository;
import pe.edu.upn.marriott.services.AlquilereService;

@Service
public class AlquilerServiceImpl implements AlquilereService {
	@Autowired
	private AlquilerRepository alquilerRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Alquiler> findAll() throws Exception {
		// TODO Auto-generated method stub
		return alquilerRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Alquiler> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return alquilerRepository.findById(id);
	}

	@Override
	@Transactional
	public Alquiler save(Alquiler entity) throws Exception {
		// TODO Auto-generated method stub
		return alquilerRepository.save(entity);
	}

	@Override
	@Transactional
	public Alquiler update(Alquiler entity) throws Exception {
		// TODO Auto-generated method stub
		return alquilerRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		alquilerRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		alquilerRepository.deleteAll();
	}

}
