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


import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.repository.AlquilerRepository;
import pe.edu.upn.marriott.models.repository.HabitacionRepository;
import pe.edu.upn.marriott.services.AlquilerService;
import pe.edu.upn.marriott.services.HabitacionService;


@Controller
@RequestMapping("/habitacion")
@SessionAttributes( {"habitacion", "alquiler" } )
public class HabitacionController {

	@Autowired
	private HabitacionService habitacionService;

	@Autowired
	private AlquilerService alquilerService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Habitacion> habitaciones = habitacionService.findAll();
			model.addAttribute("habitaciones", habitaciones);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/habitacion/inicio";
	}
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Habitacion> optional = habitacionService.findById(id);
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
			habitacionService.save(habitacion);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/habitacion";
	}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Habitacion habitacion= new Habitacion();
		
		model.addAttribute("habitacion",habitacion);
		
		
		
		return "/habitacion/nuevo";
	}
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model ) {
		try {
			Optional<Habitacion> habitacion= habitacionService.findById(id);
			if(habitacion.isPresent()) {
				habitacionService.deleteById(id);
				
				
			}
			
		} catch (Exception e) {
			model.addAttribute("dangerDel","ERROR - Violacion contra el principio de Integridad ");
			try {
				List<Habitacion> habitacion= habitacionService.findAll();
				model.addAttribute("habitacion",habitacion);
			
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
			Optional<Habitacion> habitacion= habitacionService.findById(id);
			if(habitacion.isPresent()) {
				model.addAttribute("habitacion",habitacion.get());
				
				
			}
			else {
				
				return "redirect:/habitacion";
			}
			
		} catch (Exception e) {
			
			}
			
		
		return "/habitacion/info";
		
	}
	@GetMapping("/{id}/nuevoalquiler")
	public String nuevoPaciente(@PathVariable("id") int id, Model model) {
		Alquiler alquiler = new Alquiler();
		try {
			Optional<Habitacion> habitacion = habitacionService.findById(id);
			if(habitacion.isPresent()) {
				alquiler.setHabitacion(habitacion.get());
				model.addAttribute("alquiler", alquiler);
			} else {
				return "redirect:/medico";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/medico/nuevoalquiler";
	}
	@PostMapping("/savealquiler")
	public String savePaciente(@ModelAttribute("alquiler") Alquiler alquiler, 
			Model model, SessionStatus status) {
		try {
			alquilerService.save(alquiler);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/habitacion/info/" + alquiler.getHabitacion().getId();
	}
}
