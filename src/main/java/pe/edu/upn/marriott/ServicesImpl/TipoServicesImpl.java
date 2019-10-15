package pe.edu.upn.marriott.ServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upn.marriott.models.entity.Tipo;
import pe.edu.upn.marriott.models.repository.AlquilerRepository;
import pe.edu.upn.marriott.models.repository.TipoRepository;
import pe.edu.upn.marriott.services.TipoServices;

@Service
public class TipoServicesImpl implements TipoServices{
	

	@Autowired
	private TipoRepository tipoRepository;

	@Override
	public List<Tipo> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Tipo> findById(String id) throws Exception {
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
	public void deleteById(String id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
