package pe.edu.upn.marriott.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.repository.AlquilerRepository;
import pe.edu.upn.marriott.models.repository.HabitacionRepository;


@Controller
@RequestMapping("/habitacion")
@SessionAttributes({"habitacion","alquiler"})
public class HabitacionController {

	@Autowired
	private HabitacionRepository habitacionRepository;
	@Autowired
	private AlquilerRepository alquilerRepository;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Habitacion> habitaciones = habitacionRepository.findAll();
			model.addAttribute("habitaciones", habitaciones);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/habitacion/inicio";
	}
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Habitacion> optional = habitacionRepository.findById(id);
			if (optional.isPresent()) {
				
				model.addAttribute("habitacion", optional.get());
				
			} else {
				return "redirect:/habitacion";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/habitacion/edit";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("habitacion") Habitacion habitacion, 
			Model model, SessionStatus status) {
		try {
			habitacionRepository.save(habitacion);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/habitacion";
	}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Habitacion habitaciones= new Habitacion();
		
		model.addAttribute("habitaciones",habitaciones);
		
		
		
		return "/habitacion/nuevo";
	}
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model ) {
		try {
			Optional<Habitacion> habitaciones= habitacionRepository.findById(id);
			if(habitaciones.isPresent()) {
				habitacionRepository.deleteById(id);
				
				
			}
			
		} catch (Exception e) {
			model.addAttribute("dangerDel","ERROR - Violacion contra el principio de Integridad ");
			try {
				List<Habitacion> habitaciones= habitacionRepository.findAll();
				model.addAttribute("habitaciones",habitaciones);
			
			} catch (Exception e2) {
				// TODO: handle exception
			}
			return "/habitacion/inicio";

		}
				
		return "redirect:/habitacion";
				
				
			}
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model ) {
		try {
			Optional<Habitacion> habitaciones= habitacionRepository.findById(id);
			if(habitaciones.isPresent()) {
				model.addAttribute("habitaciones",habitaciones.get());
				
				
			}
			else {
				
				return "redirect:/habitacion";
			}
			
		} catch (Exception e) {
			
			}
			
		
		return "/habitacion/info";
		
	}
}
