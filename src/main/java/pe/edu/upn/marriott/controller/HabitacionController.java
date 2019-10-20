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

import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.entity.Tipo;
import pe.edu.upn.marriott.services.habitacionService;
import pe.edu.upn.marriott.services.tipoService;

@Controller
@RequestMapping("/habitaciones")
@SessionAttributes( {"habitacion","tipo"} )
public class HabitacionController {

	@Autowired
	private habitacionService habitacionService;
	
	private tipoService tipoService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Habitacion> habitaciones = habitacionService.findAll();
			model.addAttribute("habitaciones", habitaciones);
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
				
				model.addAttribute("habitacion", optional.get());
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
	public String save(@ModelAttribute("habitacion") Habitacion habitacion, 
			Model model, SessionStatus status) {
		try {
			habitacionService.save(habitacion);
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
			List<Tipo> tipos = 
					tipoService.findAll();
			model.addAttribute("tipos", tipos);
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
			
			model.addAttribute("dangerDel", "ERROR - ViolaciÃ³n contra el principio de Integridad referencia");
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
				model.addAttribute("habitacion", habitacion.get());
			} else {
				return "redirect:/habitacion";
			}
		} catch (Exception e) {

		}	
		
		return "/habitaciones/info";
	}
	
}