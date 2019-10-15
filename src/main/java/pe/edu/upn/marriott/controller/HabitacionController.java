package pe.edu.upn.marriott.controller;

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
import pe.edu.upn.marriott.models.entity.Tipo;

import pe.edu.upn.marriott.service.HabitacionService;
import pe.edu.upn.marriott.service.TipoService;
import pe.edu.upn.marriott.service.AlquilerService;


@Controller
@RequestMapping("/habitaciones")
@SessionAttributes("habitacion")
public class HabitacionController {

	@Autowired
	private HabitacionService habitacionService;
	
	@Autowired
	private TipoService tipoService;
	
	@Autowired
	private AlquilerService alquilerService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Habitacion> habitaciones = habitacionService.findAll();
			model.addAttribute("Habitacion", habitaciones);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/habitaciones/inicio";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Habitacion> optional = habitacionService.findById(id);
			if (optional.isPresent()) {
				
				List<Tipo> tipos = tipoService.findAll(); 
				
				model.addAttribute("habitaciones", optional.get());
				model.addAttribute("tipos", tipos);
			} else {
				return "redirect:/habitaciones";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/habitaciones/edit";
	}
	
	
	@PostMapping("/save")
	public String save(@ModelAttribute("habitaciones") Habitacion habitaciones, 
			Model model, SessionStatus status) {
		try {
			habitacionService.save(habitaciones);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/habitaciones";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Habitacion habitacion = new Habitacion();
		model.addAttribute("habitaciones", habitacion);
		try {
			List<Tipo> tipos = tipoService.findAll();
			model.addAttribute("Tipo", tipos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/habitaciones/nuevo";
	}
	
	
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Habitacion> habitacion = habitacionService.findById(id);
			if(habitacion.isPresent()) {
				habitacionService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Habitacion> habitaciones = habitacionService.findAll();
				model.addAttribute("habitaciones", habitaciones);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/habitaciones/inicio";
		}
		return "redirect:/habitaciones";
	}
	
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Habitacion> habitacion = habitacionService.findById(id);
			if(habitacion.isPresent()) {
				List<Alquiler> alquilers = alquilerService.findAll();
				model.addAttribute("habitaciones", habitacion.get());
				model.addAttribute("Alquiler", alquilers);
			} else {
				return "redirect:/habitaciones";
			}
		} catch (Exception e) {

		}	
		
		return "/habitaciones/info";
	}
	
	@GetMapping("/{id}/nuevoalquiler")
	public String nuevoPaciente(@PathVariable("id") int id, Model model) {
		Alquiler alquilers = new Alquiler();
		try {
			Optional<Habitacion> habitaciones = habitacionService.findById(id);
			if(habitaciones.isPresent()) {
				alquilers.setHabitacionID(habitaciones.get());
				model.addAttribute("Alquiler", alquilers);
			} else {
				return "redirect:/habitaciones";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/habitaciones/nuevoalquiler";
	}
	
	
	@PostMapping("/saveAlquiler")
	public String savePaciente(@ModelAttribute("Alquiler") Alquiler alquiler, 
			Model model, SessionStatus status) {
		try {
			alquilerService.save(alquiler);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/habitaciones/info/" + alquiler.getHabitacionID().getId();
	}
	
}
