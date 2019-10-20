package pe.edu.upn.marriott.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import pe.edu.upn.marriott.models.entity.Tipo;
import pe.edu.upn.marriott.models.repository.TipoRepository;
import pe.edu.upn.marriott.services.tipoService;

public class tipoServiceImpl implements tipoService{

	@Autowired
	private TipoRepository tipoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Tipo> findAll() throws Exception {
		return tipoRepository.findAll();
	}

	@Override
	public Optional<Tipo> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tipo save(Tipo entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tipo update(Tipo entity) throws Exception {
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
