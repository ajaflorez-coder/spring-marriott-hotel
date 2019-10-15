package pe.edu.upn.marriott.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.models.repository.VendedorRepository;
import pe.edu.upn.marriott.services.VendedorService;

@Service
public class VendedorServicesImpl implements VendedorService {

	@Autowired
	private VendedorRepository vendedorrepository;
	
	@Override
	public List<Vendedor> findAll() throws Exception {
		// TODO Auto-generated method stub
		return vendedorrepository.findAll();
	}

	@Override
	public Optional<Vendedor> findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return vendedorrepository.findById(id);
	}

	@Override
	public Vendedor save(Vendedor entity) throws Exception {
		// TODO Auto-generated method stub
		return vendedorrepository.save(entity);
	}

	@Override
	public Vendedor update(Vendedor entity) throws Exception {
		// TODO Auto-generated method stub
		return vendedorrepository.save(entity);
	}

	@Override
	public void deleteById(String id) throws Exception {
		// TODO Auto-generated method stub
		vendedorrepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		vendedorrepository.deleteAll();
	}

}
