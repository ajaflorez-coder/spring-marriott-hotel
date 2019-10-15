package pe.edu.upn.marriott.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.models.repository.VendedorRepository;
import pe.edu.upn.marriott.services.VendedorService;

@Service
public class VendedorServiceImp implements VendedorService{
	
	@Autowired
	private VendedorRepository vendedorRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Vendedor> findAll() throws Exception {
		return vendedorRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Vendedor> findById(String id) throws Exception {
		return vendedorRepository.findById(id);
	}

	@Transactional
	@Override
	public Vendedor save(Vendedor entity) throws Exception {
		return vendedorRepository.save(entity);
	}

	@Transactional
	@Override
	public Vendedor update(Vendedor entity) throws Exception {
		return vendedorRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(String id) throws Exception {
		vendedorRepository.deleteById(id);
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		vendedorRepository.deleteAll();
	}

}
