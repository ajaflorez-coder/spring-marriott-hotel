package pe.edu.upn.marriott.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.models.repository.VendedorRepository;
import pe.edu.upn.marriott.services.VendedorService;

@Service
public class VendedorServiceImpl implements VendedorService {
	@Autowired
	private VendedorRepository vendedorRepository;
	
	
	@Transactional(readOnly = true)
	@Override
	public List<Vendedor> findAll() throws Exception {
		// TODO Auto-generated method stub
		return vendedorRepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Vendedor> findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return vendedorRepository.findById(id);
	}

	@Override
	public Vendedor save(Vendedor entity) throws Exception {
		// TODO Auto-generated method stub
		return vendedorRepository.save(entity);
	}

	@Override
	public Vendedor update(Vendedor entity) throws Exception {
		// TODO Auto-generated method stub
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
