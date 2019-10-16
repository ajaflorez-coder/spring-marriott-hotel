package pe.edu.upn.marriott.services.servicesimplem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upn.marriott.models.entity.Cliente;
import pe.edu.upn.marriott.models.repository.ClienteRepository;
import pe.edu.upn.marriott.services.ClienteService;

@Service
public class ClienteImplem implements ClienteService {

	@Autowired ClienteRepository cliente;
	
	
	@Override
	public List<Cliente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return cliente.findAll();
	}

	@Override
	public Optional<Cliente> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return cliente.findById(id);
	}

	@Override
	public Cliente save(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return cliente.save(entity);
	}

	@Override
	public Cliente update(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return cliente.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		cliente.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		cliente.deleteAll();
	}

}
