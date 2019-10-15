package pe.edu.upn.marriott.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.repository.AlquilerRepository;
import pe.edu.upn.marriott.models.repository.HabitacionRepository;
import pe.edu.upn.marriott.services.HabitacionService;

@Service
public class HabitacionServicesImpl implements HabitacionService{
	
	@Autowired
	private HabitacionRepository habitacionrepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Habitacion> findAll() throws Exception {
		// TODO Auto-generated method stub
		return habitacionrepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Habitacion> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return habitacionrepository.findById(id);
	}

	@Override
	@Transactional
	public Habitacion save(Habitacion entity) throws Exception {
		// TODO Auto-generated method stub
		return habitacionrepository.save(entity);
	}

	@Override
	public Habitacion update(Habitacion entity) throws Exception {
		// TODO Auto-generated method stub
		return habitacionrepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		habitacionrepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		habitacionrepository.deleteAll();
	}
}
