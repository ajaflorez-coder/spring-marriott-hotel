package pe.edu.upn.marriott.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.models.repository.VendedorRepository;
import pe.edu.upn.marriott.services.VendedorService;

@Service
public class VendedorServiceImpl implements VendedorService{

	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Vendedor> findAll() throws Exception {
		return vendedorRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Vendedor> findById(String id) throws Exception {
		return vendedorRepository.findById(id);
	}

	@Override
	@Transactional
	public Vendedor save(Vendedor entity) throws Exception {
		return vendedorRepository.save(entity);
	}

	@Override
	@Transactional
	public Vendedor update(Vendedor entity) throws Exception {
		return vendedorRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(String id) throws Exception {
		vendedorRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		vendedorRepository.deleteAll();
	}

}
