package pe.edu.upn.marriott.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.repository.HabitacionRepository;
import pe.edu.upn.marriott.services.HabitacionService;

@Service
public class HabitacionServiceImpl implements HabitacionService{

	
	
	@Autowired
	private HabitacionRepository habitacionRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Habitacion> findAll() throws Exception {
		// TODO Auto-generated method stub
		return habitacionRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Habitacion> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return habitacionRepository.findById(id);
	}
    
	@Transactional
	@Override
	public Habitacion save(Habitacion entity) throws Exception {
		// TODO Auto-generated method stub
		return habitacionRepository.save(entity);
	}
	@Transactional
	@Override
	public Habitacion update(Habitacion entity) throws Exception {
		// TODO Auto-generated method stub
		return habitacionRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		habitacionRepository.deleteById(id);
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		habitacionRepository.deleteAll();
	}

}
