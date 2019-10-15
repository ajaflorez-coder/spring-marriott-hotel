package pe.edu.upn.marriott.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upn.marriott.models.entity.Tipo;
import pe.edu.upn.marriott.models.repository.TipoRepository;
import pe.edu.upn.marriott.services.TipoService;

@Service
public class TipoServiceImpl implements TipoService{

	@Autowired	
	private TipoRepository tipoRepository;

	@Override
	public List<Tipo> findAll() throws Exception {
		return tipoRepository.findAll();
	}

	@Override
	public Optional<Tipo> findById(String id) throws Exception {
		return tipoRepository.findById(id);
	}

	@Override
	public Tipo save(Tipo entity) throws Exception {
		return tipoRepository.save(entity);
	}

	@Override
	public Tipo update(Tipo entity) throws Exception {
		return tipoRepository.save(entity);
	}

	@Override
	public void deleteById(String id) throws Exception {
		tipoRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		tipoRepository.deleteAll();
	}
}