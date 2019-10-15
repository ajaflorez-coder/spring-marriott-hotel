package pe.edu.upn.marriott.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.models.repository.VendedorRepository;
import pe.edu.upn.marriott.services.VendedorService;

@Service
public class VendedorServiceImpl implements VendedorService{

	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Override
	public List<Vendedor> findAll() throws Exception {
		return vendedorRepository.findAll();
	}

	@Override
	public Optional<Vendedor> findById(String id) throws Exception {
		return vendedorRepository.findById(id);
	}

	@Override
	public Vendedor save(Vendedor entity) throws Exception {
		return vendedorRepository.save(entity);
	}

	@Override
	public Vendedor update(Vendedor entity) throws Exception {
		return vendedorRepository.save(entity);
	}

	@Override
	public void deleteById(String id) throws Exception {
		vendedorRepository.deleteById(id);
		
	}

	@Override
	public void deleteAll() throws Exception {
		vendedorRepository.deleteAll();
		
	}

}
