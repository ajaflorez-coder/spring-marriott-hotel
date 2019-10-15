package pe.edu.upn.marriott.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.entity.Tipo;
import pe.edu.upn.marriott.services.HabitacionService;
import pe.edu.upn.marriott.services.TipoService;

@Controller
@RequestMapping("/habitacion")
@SessionAttributes("habitacion")
public class HabitacionController {

	@Autowired
	private HabitacionService habitacionService;
	
	@Autowired
	private TipoService tipoService;
	
	
	
	@PostMapping("/save")
	public String save(@ModelAttribute("habitacion")Habitacion habitacion, Model model,SessionStatus status) {
	     try {
			habitacionService.save(habitacion);
			status.setComplete();
		} catch (Exception e) {
			// TODO: handle exception
		}
	     return "redirect:/";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Habitacion habitacion=new Habitacion();
		model.addAttribute("habitacion", habitacion);
		
		
		try {
			List<Tipo>tipos=tipoService.findAll();
			model.addAttribute("tipos", tipos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/habitacion/nuevo";
	}
}
