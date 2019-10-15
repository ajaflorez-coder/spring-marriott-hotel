package pe.edu.upn.marriott.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.repository.AlquilerRepository;
import pe.edu.upn.marriott.services.AlquilerService;

@Service
public class AlquilerServicesImpl implements AlquilerService {
	
	@Autowired
	private AlquilerRepository alquilerrepository;
	@Transactional(readOnly = true)
	@Override
	public List<Alquiler> findAll() throws Exception {
	
		return alquilerrepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Alquiler> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return alquilerrepository.findById(id);
	}
	@Transactional
	@Override
	public Alquiler save(Alquiler entity) throws Exception {
		// TODO Auto-generated method stub
		return alquilerrepository.save(entity);
	}
	@Transactional
	@Override
	public Alquiler update(Alquiler entity) throws Exception {
		// TODO Auto-generated method stub
		return alquilerrepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		
		alquilerrepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		
		alquilerrepository.deleteAll();
		
	}

}
