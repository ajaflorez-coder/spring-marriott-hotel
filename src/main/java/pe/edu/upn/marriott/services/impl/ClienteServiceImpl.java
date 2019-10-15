package pe.edu.upn.marriott.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.marriott.models.entity.Cliente;
import pe.edu.upn.marriott.models.repository.ClienteRepository;
import pe.edu.upn.marriott.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() throws Exception {
		return clienteRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> findById(Integer id) throws Exception {
		return clienteRepository.findById(id);
	}

	@Override
	@Transactional
	public Cliente save(Cliente entity) throws Exception {
		return clienteRepository.save(entity);
	}

	@Override
	@Transactional
	public Cliente update(Cliente entity) throws Exception {
		return clienteRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		clienteRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		clienteRepository.deleteAll();
	}

	
	
}
