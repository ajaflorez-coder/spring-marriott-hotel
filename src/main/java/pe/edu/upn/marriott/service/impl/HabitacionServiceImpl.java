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
public class HabitacionServiceImpl implements HabitacionService {

	@Autowired
	private HabitacionRepository habitacionRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Habitacion> findAll() throws Exception {
		return habitacionRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Habitacion> findById(Integer id) throws Exception {
		return habitacionRepository.findById(id);
	}

	@Override
	@Transactional
	public Habitacion save(Habitacion entity) throws Exception {
		return habitacionRepository.save(entity);
	}

	@Override
	@Transactional
	public Habitacion update(Habitacion entity) throws Exception {
		return habitacionRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		habitacionRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		habitacionRepository.deleteAll();
	}

}
