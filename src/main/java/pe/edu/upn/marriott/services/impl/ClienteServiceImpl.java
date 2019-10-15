package pe.edu.upn.marriott.services.impl;

import java.util.List;
import java.util.Optional;

import pe.edu.upn.marriott.models.entity.Cliente;
import pe.edu.upn.marriott.models.repository.ClienteRepository;
import pe.edu.upn.marriott.services.ClienteService;

public class ClienteServiceImpl implements ClienteService{

	private ClienteRepository clienteRepository;
	@Override
	public List<Cliente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Override
	public Optional<Cliente> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id);
	}

	@Override
	public Cliente save(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.save(entity);
	}

	@Override
	public Cliente update(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		clienteRepository.deleteAll();
	}

}
