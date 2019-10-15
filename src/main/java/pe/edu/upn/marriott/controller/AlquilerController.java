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
import pe.edu.upn.marriott.services.AlquilerService;

import pe.edu.upn.marriott.services.HabitacionService;

@Controller
@RequestMapping("/alquiler")
@SessionAttributes({"alquiler","habitacion"})
public class AlquilerController {
	
	@Autowired
	private AlquilerService alquilerService;
	
	
	@Autowired
	private HabitacionService habitacionService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List <Alquiler> alquileres=alquilerService.findAll();
			model.addAttribute("alquileres",alquileres);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/alquiler/inicio";
	

}
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Alquiler> optional = alquilerService.findById(id);
			if (optional.isPresent()) {
				
				List<Habitacion> habitaciones
					=habitacionService.findAll();
				
				model.addAttribute("cliente", optional.get());
				model.addAttribute("habitaciones", habitaciones);
			} else {
				return "redirect:/alquiler";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/alquiler/edit";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("alquiler") Alquiler alquiler, 
			Model model, SessionStatus status) {
		try {
			alquilerService.save(alquiler);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/alquiler";
	}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Alquiler alquiler = new Alquiler();
		model.addAttribute("alquiler", alquiler);
		try {
			List<Habitacion> habitaciones = 
					habitacionService.findAll();
			model.addAttribute("habitaciones",habitaciones);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/alquiler/nuevo";
	}
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Alquiler> alquiler = alquilerService.findById(id);
			if(alquiler.isPresent()) {
				alquilerService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - ViolaciÃ³n contra el principio de Integridad referencia");
			try {
				List<Alquiler> alquileres = alquilerService.findAll();
				model.addAttribute("alquileres", alquileres);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/alquiler/inicio";
		}
		return "redirect:/alquiler";
	}
	
}
