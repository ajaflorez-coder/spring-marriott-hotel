package pe.edu.upn.marriott.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.marriott.models.entity.Tipo;
import pe.edu.upn.marriott.models.repository.TipoRepository;
import pe.edu.upn.marriott.services.TipoService;

@Service
public class TipoServiceImpl implements TipoService{

	@Autowired
	private TipoRepository tipoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Tipo> findAll() throws Exception {
		// TODO Auto-generated method stub
		return tipoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Tipo> findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return tipoRepository.findById(id);
	}

	@Override
	@Transactional
	public Tipo save(Tipo entity) throws Exception {
		// TODO Auto-generated method stub
		return tipoRepository.save(entity);
	}

	@Override
	@Transactional
	public Tipo update(Tipo entity) throws Exception {
		// TODO Auto-generated method stub
		return tipoRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(String id) throws Exception {
		// TODO Auto-generated method stub
		tipoRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		tipoRepository.deleteAll();
	}

	
	
}
