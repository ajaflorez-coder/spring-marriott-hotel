package pe.edu.upn.marriott.Controller;

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
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.entity.Tipo;
import pe.edu.upn.marriott.services.AlquilerService;
import pe.edu.upn.marriott.services.HabitacionService;
import pe.edu.upn.marriott.services.TipoService;

@Controller
@RequestMapping("/habitacion") 
public class HabitacionController {
	
	@Autowired
	HabitacionService habitacionService;
	
	@Autowired
	AlquilerService alquilerService;
	
	@Autowired
	TipoService tipoService;
	
	@GetMapping
	public String inicio(Model model){
		try {
			List<Habitacion> habitaciones=habitacionService.findAll();
			model.addAttribute("habitaciones",habitaciones); //en thymeleaf va el nombre que va en comillas
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "habitacion/inicio.html";
	}
	
	@GetMapping("/editar/{id}")//("/edit/{id}/{id2}")
	public String editar(@PathVariable("id") Integer id,Model model) {//editar(@PathVariable("id") Integer id,@PathVariable("id2") Integer id2,Model model) {
		try {
			Optional<Habitacion>optional=habitacionService.findById(id);
			if(optional.isPresent()) {
				List<Alquiler> alquileres=alquilerService.findAll();
				model.addAttribute("habitaciones",optional.get());
				model.addAttribute("alquileres",alquileres);
			}else {
				return "redirect:/medico";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "habitacion/editar.html";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Habitacion habitacion=new Habitacion();
		model.addAttribute("habitaciones",habitacion);
		try {
			List<Tipo> tipos=tipoService.findAll();
			model.addAttribute("tipos",tipos);
		} catch (Exception e) {
		}
		return "habitacion/nuevo";
	}
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute("habitaciones") Habitacion habitacion, Model model, SessionStatus status) {
		try {
			habitacionService.save(habitacion);
			status.setComplete();
			model.addAttribute("success", "Habitacion guardado");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/habitacion";
	}
	
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Habitacion> habitacionOptional=habitacionService.findById(id);
			if(habitacionOptional.isPresent()) {
				habitacionService.deleteById(id);
			}
		} catch (Exception e) {
			model.addAttribute("danger_del","Error - Violacion contra el principio de integridad referencial");
			try {
				List<Habitacion> habitacion=habitacionService.findAll();
				model.addAttribute("habitaciones",habitacion);
			} catch (Exception e1) {
			}
			return "/habitacion/inicio";
		}
		return "redirect:/habitacion";
	}
}
