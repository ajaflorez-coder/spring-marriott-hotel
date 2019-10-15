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
import pe.edu.upn.marriott.services.HabitacionServices;
import pe.edu.upn.marriott.services.TipoServices;

@Controller
@RequestMapping("/habitaciones")
@SessionAttributes({"habitacion"})
public class HabitacionController {
	
	
	@Autowired
	private HabitacionServices habitacionServices;
	
	@Autowired
	private TipoServices tipoServices;

	@GetMapping
	public String inicio (Model model) {
	
	try {
		List<Habitacion> habitaciones = habitacionServices.findAll();
		model.addAttribute("habitaciones", habitaciones);//habitaciones rojo, es el objeto que se crea y le azul es el nombre con el que se envía al html
	} catch (Exception e) {
		// TODO: handle exception
	}
	return "/habitaciones/listado";
	
	}
	
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			
			Optional<Habitacion> optional = habitacionServices.findById(id);
		
			
			if (optional.isPresent()) {
				
				List<Tipo> tipos 
					= tipoServices.findAll();
				
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
			habitacionServices.save(habitacion);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/habitaciones";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Habitacion habitacion = new Habitacion();
		
		model.addAttribute("habitacion", habitacion);
		
		try {
			List<Tipo> tipos = tipoServices.findAll();
			model.addAttribute("tipos", tipos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/habitaciones/nuevo";
	}
	
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Habitacion> habitaciones = habitacionServices.findById(id);
			if(habitaciones.isPresent()) {
				habitacionServices.deleteById(id);
			}
		} catch (Exception e) {
			model.addAttribute("dangerDel", "ERROR - Violacion contra el principio de Integridad Referencial");
			try {
				List<Habitacion> habitacion= habitacionServices.findAll();
				model.addAttribute("habitaciones", habitacion);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			return "/habitaciones/listado";
		}
		
		return "redirect:/habitaciones";
	}
	
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Habitacion> habitaciones= habitacionServices.findById(id);
			
			if(habitaciones.isPresent()) {
				model.addAttribute("habitacion", habitaciones.get());
			}else {
				return "redirect:/habitaciones";
			}
		} catch (Exception e) {
			
		}
		return "/habitaciones/info";
	}
	
	/*@GetMapping("/{id}/nuevopaciente")
	public String nuevoPaciente(@PathVariable("id") int id, Model model) {
		Paciente paciente = new Paciente();
		
		try {
			Optional<Medico> medico = medicoService.findById(id);
			
			if(medico.isPresent()) {
				paciente.setMedico(medico.get());
				model.addAttribute("paciente", paciente);
			}else {
				return "redirect:/medico";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/medico/nuevopaciente";
	}
	
	@PostMapping("/savepaciente")
	public String savePaciente(@ModelAttribute("paciente") Paciente paciente, 
			Model model, SessionStatus status) {
		try {
			pacienteService.save(paciente);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/medico/info/" + paciente.getMedico().getId();
	}*/
	
	
}
