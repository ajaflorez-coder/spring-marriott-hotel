package pe.edu.upn.marriott.Implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.marriott.models.entity.Tipo;
import pe.edu.upn.marriott.models.repository.TipoRepository;
import pe.edu.upn.marriott.services.TipoService;

@Service
public class TipoServiceImplement implements TipoService{

	@Autowired
	TipoRepository tipoRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Tipo> findAll() throws Exception {
		// TODO Auto-generated method stub
		return tipoRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Tipo> findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return tipoRepository.findById(id);
	}

	@Transactional
	@Override
	public Tipo save(Tipo entity) throws Exception {
		// TODO Auto-generated method stub
		return tipoRepository.save(entity);
	}

	@Transactional
	@Override
	public Tipo update(Tipo entity) throws Exception {
		// TODO Auto-generated method stub
		return tipoRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(String id) throws Exception {
		// TODO Auto-generated method stub
		tipoRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		tipoRepository.deleteAll();
	}

}
