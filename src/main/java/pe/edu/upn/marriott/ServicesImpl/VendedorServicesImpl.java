package pe.edu.upn.marriott.ServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.models.repository.AlquilerRepository;
import pe.edu.upn.marriott.models.repository.VendedorRepository;
import pe.edu.upn.marriott.services.VendedorServices;

@Service
public class VendedorServicesImpl implements VendedorServices{
	

	@Autowired
	private VendedorRepository vendedorRepository;

	@Override
	public List<Vendedor> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Vendedor> findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vendedor save(Vendedor entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vendedor update(Vendedor entity) throws Exception {
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
