package pe.edu.upn.marriott.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.repository.HabitacionRepository;
import pe.edu.upn.marriott.services.habitacionService;

@Service
public class habitacionServiceImpl implements habitacionService{

	@Autowired
	public HabitacionRepository habitacionRepository;
	
	@Transactional(readOnly = true)
	public List<Habitacion> findAll() throws Exception {
		return habitacionRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Optional<Habitacion> findById(Integer id) throws Exception {
		return habitacionRepository.findById(id);
	}
	@Transactional
	public Habitacion save(Habitacion entity) throws Exception {
		return habitacionRepository.save(entity);
	}
	@Transactional
	public Habitacion update(Habitacion entity) throws Exception {
		return habitacionRepository.save(entity);
	}
	@Transactional
	public void deleteById(Integer id) throws Exception {
		habitacionRepository.deleteById(id);
		
	}
	@Transactional
	public void deleteAll() throws Exception {
		habitacionRepository.deleteAll();
	}
}
