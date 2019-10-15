package pe.edu.upn.marriott.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.entity.Cliente;
import pe.edu.upn.marriott.models.repository.AlquilerRepository;
import pe.edu.upn.marriott.models.repository.ClienteRepository;
import pe.edu.upn.marriott.services.ClienteService;

@Service
public class ClienteServicesImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienterepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return clienterepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return clienterepository.findById(id);
	}

	@Override
	@Transactional
	public Cliente save(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return clienterepository.save(entity);
	}

	@Override
	public Cliente update(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return clienterepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		clienterepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		clienterepository.deleteAll();
	}
}
