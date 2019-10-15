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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.entity.Tipo;
import pe.edu.upn.marriott.services.AlquilerService;
import pe.edu.upn.marriott.services.HabitacionService;
import pe.edu.upn.marriott.services.TipoService;

@Controller
@RequestMapping("/habitacion") 
@SessionAttributes({"habitacion","alquiler"})
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
			model.addAttribute("habitaciones",habitaciones);
		} catch (Exception e) {
		}
		return "habitacion/inicio.html";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Integer id,Model model) {
		try {
			Optional<Habitacion>optional=habitacionService.findById(id);
			if(optional.isPresent()) {
				List<Tipo> tipos=tipoService.findAll();
				model.addAttribute("habitaciones",optional.get());
				model.addAttribute("tipos",tipos);
			}else {
				return "redirect:/habitacion";
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
			System.out.println(habitacion.getId());
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
	
	@GetMapping("/info/{id}")
	public String informacion(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Habitacion> habitacion=habitacionService.findById(id);
			if(habitacion.isPresent()) {
				model.addAttribute("habitaciones",habitacion.get());
			}else {
				return "redirect:/habitacion";
			}
		} catch (Exception e) {

		}
		return "/habitacion/info";
	}
	
	@GetMapping("/{id}/nuevoalquiler")
	public String nuevoAlquiler(@PathVariable("id")Integer id, Model model) {
		Alquiler alquiler=new Alquiler();
		try {
			Optional<Habitacion> habitacion=habitacionService.findById(id);
			if(habitacion.isPresent()) {
				List<Habitacion> habitaciones=habitacionService.findAll();//
				alquiler.setHabitacion(habitacion.get());
				model.addAttribute("alquiler",alquiler);
				model.addAttribute("habitaciones",habitaciones);//
			}else {
				return "redirect:/habitacion";
			}
		} catch (Exception e) {
		}
		return "/habitacion/nuevoalquiler";
	}
	
	@PostMapping("/guardaralquiler")
	public String guardarAlquiler(@ModelAttribute("alquileres") Alquiler alquiler, Model model, SessionStatus status) {
		try {
			alquilerService.save(alquiler);
			status.setComplete();
			model.addAttribute("success", "Alquiler guardado");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/habitacion/info/"+alquiler.getHabitacion().getId();
	}
}
