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
public class AlquilerServicesImpl implements AlquilerService{
		
	@Autowired
	private AlquilerRepository alquilerRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Alquiler> findAll() throws Exception {
		// TODO Auto-generated method stub
		return alquilerRepository.findAll();
	}

	@Override
	public Optional<Alquiler> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return alquilerRepository.findById(id);
	}

	@Override
	public Alquiler save(Alquiler entity) throws Exception {
		// TODO Auto-generated method stub
		return alquilerRepository.save(entity);
	}

	@Override
	public Alquiler update(Alquiler entity) throws Exception {
		// TODO Auto-generated method stub
		return alquilerRepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		alquilerRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		alquilerRepository.deleteAll();
	}

	
	

	

	
	
	
	
	
}
