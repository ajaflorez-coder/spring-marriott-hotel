package pe.edu.upn.marriott.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.marriott.models.entity.Tipo;
import pe.edu.upn.marriott.models.repository.TipoRepository;
import pe.edu.upn.marriott.services.TipoService;


@Service
public class TipoServiceImpl implements TipoService {
	@Autowired
    private TipoRepository tiporepository;
	
	
	@Transactional(readOnly = true)
	@Override
	public List<Tipo> findAll() throws Exception {
		// TODO Auto-generated method stub
		return tiporepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Tipo> findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return tiporepository.findById(id);
	}
	@Transactional
	@Override
	public Tipo save(Tipo entity) throws Exception {
		// TODO Auto-generated method stub
		return tiporepository.save(entity);
	}
	@Transactional
	@Override
	public Tipo update(Tipo entity) throws Exception {
		// TODO Auto-generated method stub
		return tiporepository.save(entity);
	}
    
	@Override
	public void deleteById(String id) throws Exception {
		tiporepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		tiporepository.deleteAll();
		
	}
	
	
	

}
